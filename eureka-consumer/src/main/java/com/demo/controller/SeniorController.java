package com.demo.controller;

import com.demo.entity.Senior;
import com.demo.service.SeniorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

/**
 * @author 孙小云
 * @version 4.0
 * @date 2020/7/23$ 14:13
 **/
@RestController
@RequestMapping("/senior/")
public class SeniorController {

    @Autowired
     SeniorService seniorService;
    @GetMapping("findAll")
    public List<Senior> findSenior(){
        return seniorService.findSenior();
    }
}
