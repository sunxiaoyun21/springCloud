package com.demo.utils;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

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

    //value:string
    public static String set(String key,String value,String nxxx,String expx,long timeout ){
      log.debug("{},{},{},{},{}",key,value,nxxx,expx,timeout);
       try(Jedis jedis = jedisPool.getResource()) {
           return  jedis.set(key,value,nxxx,expx,timeout);
       }
    }
    //value:string
    public static String setNx(String key,String value,String expx,long timeout){
        log.debug("{},{},{},{}",key,value,expx,timeout);
        try(Jedis jedis = jedisPool.getResource()) {
            return  jedis.set(key,value,"nx",expx,timeout);
        }
    }
    //value:string
    public static String setXx(String key,String value,String expx,long timeout){
        log.debug("{},{},{},{}",key,value,expx,timeout);
        try(Jedis jedis = jedisPool.getResource()) {
            return  jedis.set(key,value,"xx",expx,timeout);
        }
    }
    //value:string
    public static String set(String key,String value){
        log.debug("{},{}",key,value);
        try(Jedis jedis = jedisPool.getResource()) {
            return  jedis.set(key,value);
        }
    }
    //value:string
    public static String set(String key,String value,String expx,long timeout){
        log.debug("{},{},{},{}",key,value,expx,timeout);
        try(Jedis jedis = jedisPool.getResource()) {
            return  jedis.set(key,value,expx,timeout);
        }
    }
    //value:string
    public static String setNx(String key,String value){
        log.debug("{},{}",key,value);
        try(Jedis jedis = jedisPool.getResource()) {
            return  jedis.set(key,value,"nx");
        }
    }
    //value:string
    public static String setXx(String key,String value){
        log.debug("{},{}",key,value);
        try(Jedis jedis = jedisPool.getResource()) {
            return  jedis.set(key,value,"xx");
        }
    }

    //修改数据
    public  static String lSet(String key,Long index,String value){
        log.debug("{},{},{}",key,index,value);
        try(Jedis jedis = jedisPool.getResource()){
           return jedis.lset(key,index,value);
        }
    }
    //value:list
  public  static void   setList(String key, List list){
      log.debug("{},{}",key,list);
        try(Jedis jedis = jedisPool.getResource()){
            list.forEach(obj->{ String resultJson = JSONObject.toJSONString(obj);
            jedis.lpush(key,resultJson);
            });

        }

  }

    //获取zset的分数值
    public static Double getScore(String key, String value) {
        try(Jedis jedis = jedisPool.getResource()){
            return jedis.zscore(key,value);
        }

    }

    //value:zset
    public static  void  zadd(String key,Long id,String value){
        try(Jedis jedis = jedisPool.getResource()){
            jedis.zadd(key,id,value);
        }
    }


    //删除zset的值
    public static  void zremove(String key,String value){
        try(Jedis jedis = jedisPool.getResource()){
            jedis.zrem(key,value);
        }
    }
  public static Long getSize(String key){
      try(Jedis jedis = jedisPool.getResource()){
          return  jedis.llen(key);
      }
  }

  public static  List getList(String key,int begin,int end){
      log.debug("{},{},{}",key,begin,end);
        try(Jedis jedis = jedisPool.getResource()){
            return  jedis.lrange(key, begin,end);
        }
  }



    /**
     * 设置key过期时间
     * @param key
     * @param seconds
     * @return
     */
    public static  Long expire( String key, int seconds) {
        try(Jedis jedis = jedisPool.getResource()){
            return  jedis.expire(key,seconds);
        }

    }
    /**
     * 判断key值是否存在
     * @param key
     * @return
     */
  public static boolean isExit(String key){
      log.debug("{}",key);
      try (Jedis jedis =jedisPool.getResource()){
          return jedis.exists(key);
      }
  }

    /**
     * 删除指定的value值
     */
  public static void delByValue(String key,String value){
      log.debug("{},{}",key,key,value);
      try(Jedis jedis = jedisPool.getResource()){
         jedis.lrem(key,0,value);
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



    //获取zset数据 正序
    public static Set<String> zrange(String key, long start, long stop) {
        try(Jedis jedis = jedisPool.getResource()) {
            return jedis.zrange(key,start,stop);
        }
    }

    //获取zset数据 倒叙
    public static Set<String> zrevRange(String key, long start, long stop) {
        try(Jedis jedis = jedisPool.getResource()) {
            return jedis.zrevrange(key,start,stop);
        }
    }

    //获取zset数据 数量
    public  static  Long zcard(String key){
        try(Jedis jedis = jedisPool.getResource()) {
            return  jedis.zcard(key);
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
