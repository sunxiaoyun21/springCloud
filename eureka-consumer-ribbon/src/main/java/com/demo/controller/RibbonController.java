package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author 孙小云
 * @version 1.0
 * @date 2019/8/28 13:54
 **/
@RestController
public class RibbonController {


    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/getBc")
    public  String getList(){
        return restTemplate.getForObject("http://eureka-client/dept/list",String.class);
    }
}
