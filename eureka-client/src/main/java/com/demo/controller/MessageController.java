package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 孙小云
 * @version 4.0
 * @date 2020/7/2$ 14:03
 **/
@RestController
@RequestMapping("/message/")
public class MessageController {



    @GetMapping("getMessage")
     public String getMessage(){
         return "测试一下熔断，就这样!!!!";
     }



}
