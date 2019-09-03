package com.demo.controller;

import com.demo.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author 孙小云
 * @version 1.0
 * @date 2019/8/28 20:53
 **/
@RestController
public class HystrixController {


    @Autowired
   ConsumerService consumerService;

    @GetMapping("/getHy")
    public String getList(){
        return consumerService.getUserList();
    }
}
