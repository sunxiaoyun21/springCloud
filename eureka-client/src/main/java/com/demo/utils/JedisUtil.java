package com.demo.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author 孙小云
 * @version 1.0
 * @date 2019/10/9 12:00
 **/
@Component
@Slf4j
@ConditionalOnClass(JedisPool.class)
public class JedisUtil {

    private static JedisPool jedisPool;

    public JedisUtil(@Autowired(required = false) JedisPool jedisPool){
        if(jedisPool ==null){
            log.warn("jedisPool未配置成功，jedisUtil不可用");
        }else {
            log.warn("JedisUtil配置成功");
        }
        JedisUtil.jedisPool = jedisPool;
    }

    /**
     * 获取jedis连接
     * @return
     */
    public static Jedis getJedis(){
        return jedisPool.getResource();
    }

    public static String set(String key,String value,String nxxx,String expx,long timeout ){
      log.debug("{},{},{},{},{}",key,value,nxxx,expx,timeout);
       try(Jedis jedis = jedisPool.getResource()) {
           return  jedis.set(key,value,nxxx,expx,timeout);
       }
    }

    public static String setNx(String key,String value,String expx,long timeout){
        log.debug("{},{},{},{}",key,value,expx,timeout);
        try(Jedis jedis = jedisPool.getResource()) {
            return  jedis.set(key,value,"nx",expx,timeout);
        }
    }

    public static String setXx(String key,String value,String expx,long timeout){
        log.debug("{},{},{},{}",key,value,expx,timeout);
        try(Jedis jedis = jedisPool.getResource()) {
            return  jedis.set(key,value,"xx",expx,timeout);
        }
    }

    public static String set(String key,String value){
        log.debug("{},{}",key,value);
        try(Jedis jedis = jedisPool.getResource()) {
            return  jedis.set(key,value);
        }
    }

    public static String set(String key,String value,String expx,long timeout){
        log.debug("{},{},{},{}",key,value,expx,timeout);
        try(Jedis jedis = jedisPool.getResource()) {
            return  jedis.set(key,value,expx,timeout);
        }
    }
    public static String setNx(String key,String value){
        log.debug("{},{}",key,value);
        try(Jedis jedis = jedisPool.getResource()) {
            return  jedis.set(key,value,"nx");
        }
    }

    public static String setXx(String key,String value){
        log.debug("{},{}",key,value);
        try(Jedis jedis = jedisPool.getResource()) {
            return  jedis.set(key,value,"xx");
        }
    }

    /**
     * 根据key读取
     * @param key
     * @return
     */
    public static String get(String key){
        try(Jedis jedis = jedisPool.getResource()) {
            return  jedis.get(key);
        }
    }

    /***
     * 根据key删除
     * @param key
     * @return
     */
    public static Long del(String key){
        try(Jedis jedis = jedisPool.getResource()) {
            return  jedis.del(key);
        }
    }
}
