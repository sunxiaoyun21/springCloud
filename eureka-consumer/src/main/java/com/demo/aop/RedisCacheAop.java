package com.demo.aop;

import com.demo.annotation.RedisCache;
import com.demo.annotation.RedisCacheRemove;
import com.demo.utils.OthersUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import java.lang.reflect.Method;

/**
 * @author 孙小云
 * @version 4.0
 * @date 2020/7/23$ 14:24
 **/
@Component
@Aspect()
@ConditionalOnClass({Aspect.class, JedisPool.class})
public class RedisCacheAop {

    @Autowired(required = false)
    JedisPool jedisPool;


    /**
     * redisCache切入点规则
     */
    @Pointcut(value = "@annotation(com.demo.annotation.RedisCache)")
    public void pointRedisCache() {

    }

    /**
     * redisCacheRemove切入点规则
     */
    @Pointcut(value = "@annotation(com.demo.annotation.RedisCacheRemove)")
    public void pointRedisCacheRemove() {

    }

    /**
     * 切入的验证代码
     */
    @Around(value = "pointRedisCache()")
    public Object localCacheAop(ProceedingJoinPoint point) throws Throwable {
        MethodSignature joinPointObject = (MethodSignature) point.getSignature();
        Method method = joinPointObject.getMethod();
        RedisCache redisCache = method.getAnnotation(RedisCache.class);
        String key = getCacheKey(method, point.getArgs(), redisCache.value());
        long timeout = redisCache.timeout();
        try (Jedis jedis = jedisPool.getResource()) {
            byte[] cacheData = jedis.get(key.getBytes());
            Object data;
            //本地缓存为空时或者用户设置了超时时间并且已经超时，需要重新加载数据
            if (cacheData == null) {
                data = point.proceed();
                if (data != null || redisCache.cacheNull()) {
                    if (timeout != -1) {
                        switch (redisCache.unit()) {
                            case DAYS:
                                timeout = timeout * 24 * 3600 * 1000;
                                break;
                            case HOURS:
                                timeout = timeout * 3600 * 1000;
                                break;
                            case MINUTES:
                                timeout = timeout * 60 * 1000;
                                break;
                            case SECONDS:
                                timeout = timeout * 1000;
                                break;
                            case MILLISECONDS:
                                break;
                            default:
                                throw new RuntimeException("不支持的时间单位");
                        }
                    }
                    jedis.set(key.getBytes(), OthersUtils.objectToByte(data), "nx".getBytes(), "px".getBytes(), timeout);
                }
            } else {
                data = OthersUtils.byteToObject(cacheData);
            }
            return data;
        }
    }

    /**
     * 切入的验证代码
     */
    @AfterReturning(value = "pointRedisCacheRemove()")
    public void localCacheRemoveAop(JoinPoint point) {
        MethodSignature methodSignature = (MethodSignature) point.getSignature();
        Method method = methodSignature.getMethod();
        RedisCacheRemove redisCacheRemove = method.getAnnotation(RedisCacheRemove.class);
        String key = getCacheKey(method, point.getArgs(), redisCacheRemove.value());
        try(Jedis jedis = jedisPool.getResource()){
            jedis.del(key);
        }
    }

    /**
     * 解析el表达式生成缓存的key
     *
     * @param args 目标方法参数
     * @param key  表达式
     * @return
     */
    private String getCacheKey(Method method, Object[] args, String key) {
        //创建SpringEL表达式转换器
        ExpressionParser parser = new SpelExpressionParser();
        //Spring
        EvaluationContext context = new StandardEvaluationContext();
        //获取目标方法参数名
        String[] paramNames = new LocalVariableTableParameterNameDiscoverer().getParameterNames(method);
        if (paramNames == null) {
            return key;
        }
        for (int i = 0; i < args.length; i++) {
            context.setVariable(paramNames[i], args[i]);
        }
        try {
            Expression expression = parser.parseExpression(key);
            Object value = expression.getValue(context);
            return value == null || "".equals(value) ? key : value.toString();
        } catch (Exception e) {
            return key;
        }
    }

}
