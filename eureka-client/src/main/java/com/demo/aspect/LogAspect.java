package com.demo.aspect;

import com.alibaba.fastjson.JSON;
import com.demo.annotation.SystemLog;
import com.demo.entity.Log;
import com.demo.service.SystemLogService;
import com.demo.utils.IdGenerator;
import com.demo.utils.JedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.NamedThreadLocal;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;

/* @author sunxiaoyun
 * @date 2020/3/18 17:01
 */
@Aspect
@Component
@Slf4j
public class LogAspect {

    @Autowired
    private SystemLogService systemLogService;


    @Autowired
    HttpServletRequest request;

    private static final ThreadLocal<Log> logThreadLocal =
            new NamedThreadLocal<Log>("ThreadLocal log");

   // @Autowired
    //ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @Autowired
    JedisUtil jedisUtil;



   /* @Pointcut("@annotation(com.demo.log.SystemLog)")
    public void pointCut(){

    }*/


    @Around("@annotation(systemLog)")
    public Object around(ProceedingJoinPoint point, SystemLog systemLog) {
        Object result =null;
        long beginTime = System.currentTimeMillis();

        try {
            log.info("我在目标方法之前执行！");
            result = point.proceed();
            long endTime = System.currentTimeMillis();
            saveLog(point,endTime-beginTime);
        } catch (Throwable e) {
            // TODO Auto-generated catch block
        }
        return result;
    }


    private void saveLog(ProceedingJoinPoint joinPoint, long time) {
        String remoteAddr=request.getRemoteAddr();//请求的IP
        String requestUri=request.getRequestURI();//请求的Uri
        String methodType=request.getMethod();        //请求的方法类型(post/get)
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        Method method = signature.getMethod();
        Log sysLog = new Log();

        SystemLog userAction = method.getAnnotation(SystemLog.class);
        if (userAction != null) {
            // 注解上的描述
            sysLog.setTitle(userAction.value());
        }

        // 请求的类名
        String className = joinPoint.getTarget().getClass().getName();
        // 请求的方法名
        String methodName = signature.getName();
        // 请求的方法参数值
        String args = Arrays.toString(joinPoint.getArgs());



        //从session中获取当前登陆人id
//		Long useride = (Long)SecurityUtils.getSubject().getSession().getAttribute("userid");

        Long userid = 1L;//应该从session中获取当前登录人的id，这里简单模拟下

        String creatBy = "测试";

        sysLog.setCreateBy(creatBy);
        sysLog.setParams(args);
        sysLog.setMethod(methodName);
        sysLog.setRequestUri(requestUri);
        sysLog.setException(methodType);
        sysLog.setCreateDate(new Date());
        sysLog.setRemoteAddr(remoteAddr);

        log.info("当前登陆人：{},类名:{},方法名:{},参数：{},执行时间：{}",userid, className, methodName, args, time);

        //2.优化:异步保存日志
        new SaveLogThread(sysLog,systemLogService);

        //3.再优化:通过线程池来执行日志保存
        //threadPoolTaskExecutor.execute(new SaveLogThread(sysLog, systemLogService));
        //logThreadLocal.set(sysLog);

          //放入redis缓存
        String obj = JSON.toJSONString(sysLog);
        IdGenerator ig = new IdGenerator(1);
        Long id = ig.nextId();
        JedisUtil.set(id.toString(),obj);
        JedisUtil.expire(id.toString(),10000);
        systemLogService.saveLog((Log) JSON.parse(JedisUtil.get(id.toString())));

        // 保存系统日志
        //systemLogService.saveLog(sysLog);
    }

    /**
     * 保存日志线程
     */
    private static class SaveLogThread implements Runnable {
        private Log log;
        private SystemLogService logService;

        public SaveLogThread(Log log, SystemLogService logService) {
            this.log = log;
            this.logService = logService;
        }

        @Override
        public void run() {
            logService.saveLog(log);
        }
    }

}
