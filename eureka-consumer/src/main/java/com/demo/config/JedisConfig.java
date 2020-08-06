package com.demo.config;

import com.demo.properties.JedisProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author 孙小云
 * @version 1.0
 * @date 2019/10/9 10:38
 **/
@Configuration
@ConditionalOnClass(JedisPool.class)
@Slf4j
public class JedisConfig {

    @Autowired
    JedisProperties jedisProperties;

    @Bean
    public JedisPool jedisPoolFactory(){
     log.debug("JedisPool配置成功");
     return new JedisPool(jedisPoolConfig(),jedisProperties.getHost(),jedisProperties.getPost(),jedisProperties.getTimeout(),jedisProperties.getPassword());
   }

   public  JedisPoolConfig jedisPoolConfig(){
       JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
       jedisPoolConfig.setMaxIdle(jedisProperties.getMaxIdle());
       jedisPoolConfig.setMinIdle(jedisProperties.getMinIdle());
       jedisPoolConfig.setMaxTotal(jedisProperties.getMaxTotal());
       jedisPoolConfig.setMaxWaitMillis(jedisProperties.getMaxWaitMills());
        return  jedisPoolConfig;
   }
}
