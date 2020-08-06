package com.demo.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * jedis操作
 *
 * @author Allison
 * @version 1.0
 * @date 2019/5/14 10:49
 **/
@Component
@ConditionalOnClass(JedisPool.class)
@Slf4j
public class JedisUtils {

    private static JedisPool jedisPool;

    public JedisUtils(@Autowired(required = false) JedisPool jedisPool) {
        log.info("JedisUtils配置成功");
        JedisUtils.jedisPool = jedisPool;
    }

    /**
     * 获取jedis连接
     *
     * @return
     */
    public static Jedis getJedis() {
        return jedisPool.getResource();
    }

    public static String set(String key, String value, String nxxx, String expx, long timeout) {
        try(Jedis jedis=jedisPool.getResource()){
            return jedis.set(key, value, nxxx, expx, timeout);
        }
    }

    public static String set(String key, String value) {
        try(Jedis jedis=jedisPool.getResource()){
            return jedis.set(key, value);
        }
    }

    public static String set(String key, String value, String expx, long timeout) {
        try(Jedis jedis=jedisPool.getResource()){
            return jedis.set(key, value,"nx", expx, timeout);
        }
    }

    public static String set(String key, String value, String nxxx) {
        try(Jedis jedis=jedisPool.getResource()){
            return jedis.set(key, value, nxxx);
        }
    }

    public static String get(String key) {
        try(Jedis jedis=jedisPool.getResource()){
            return jedis.get(key);
        }
    }
}
