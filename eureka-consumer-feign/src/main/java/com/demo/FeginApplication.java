package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author 孙小云
 * @version 1.0
 * @date 2019/8/7 10:10
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class FeginApplication {


    public static void main(String[] args){
        SpringApplication.run(FeginApplication.class,args);
    }
}
