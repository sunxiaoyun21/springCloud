package com.demo.aspect;

import com.alibaba.fastjson.JSONObject;
import com.demo.annotation.SystemGetLog;
import com.demo.annotation.SystemLog;
import com.demo.utils.JedisUtil;
import com.google.gson.JsonObject;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.BaseMapper;

import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * @author sunxiaoyun
 * @date 2020/3/24 16:14
 */
@Aspect
@Component
@Slf4j
public class SystemGetLogAspect {

    @Autowired
    JedisUtil jedisUtil;

    @Around("@annotation(systemGetLog)")
    public Object around(ProceedingJoinPoint point, SystemGetLog systemGetLog) throws Throwable {
        MethodSignature signature = (MethodSignature)point.getSignature();
        // 请求的方法参数值
        Object[] args = point.getArgs();
        Arrays.stream(args).forEach(it->{
            Object  object = null;
            try {
                object = point.proceed();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
            String jsonObject = JSONObject.toJSONString(object);
            JedisUtil.set(it.toString(),jsonObject);
            System.out.printf(JedisUtil.get(it.toString()));

        });

        return true;
    }
}
