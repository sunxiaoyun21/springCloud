package com.demo.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author 孙小云
 * @version 1.0
 * @date 2019/8/29 10:45
 **/
@Component
public class ConsumerService {

    @Autowired
    RestTemplate restTemplate;


    @HystrixCommand(fallbackMethod = "fallBack")
    public String getUserList(){
        return restTemplate.getForObject("http://eureka-client/dept/list",String.class);
    }


    private String fallBack(){
        return "系统服务异常,请重试!!!";
    }
}
