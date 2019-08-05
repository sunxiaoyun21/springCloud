package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author 孙小云
 * @version 1.0
 * @date 2019/8/5 14:24
 **/

@SpringBootApplication
@EnableEurekaClient
public class ClientApplication {
    public static void main(String[] args){

        SpringApplication.run(ClientApplication.class,args);
    }
}
