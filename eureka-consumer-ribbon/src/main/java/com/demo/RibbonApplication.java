package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author 孙小云
 * @version 1.0
 * @date 2019/8/28 13:47
 **/
@EnableEurekaClient
@SpringBootApplication
public class  RibbonApplication {

    @Bean
    @LoadBalanced
    public RestTemplate template(){
        return new RestTemplate();
    }



    public static void main(String[] args){
        SpringApplication.run(RibbonApplication.class,args);
    }
}
