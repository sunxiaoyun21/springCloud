package com.demo.properties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author 孙小云
 * @version 1.0
 * @date 2019/10/9 10:17
 **/
@Data
@ConfigurationProperties(prefix = "jedis")
@Component
@AllArgsConstructor
@NoArgsConstructor
public class JedisProperties {

    /**
     * 是否启用
     */
    private boolean enable = false;

    /**
     * 主机地址
     */
    private String host = "localhost";

    private  String password ;

    /**
     * 端口号
     */
    private  int post = 6379;

    /**
     * 数据库
     */
    private  int database = 0;
    /**
     * 连接超时 单位：ms
     */
    private int timeout = 2000;

    /**
     * 最小闲置连接数
     */
    private int minIdle = 10;
    /**
     * 最大闲置连接数
     */
    private int maxIdle =50;
    /**
     * 最大活动对象数
     */
    private  int maxTotal = 500;
    /**
     * 获取连接最大等待时间(ms)
     */
    private  int maxWaitMills = 1000;
}
