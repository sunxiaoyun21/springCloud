package com.demo.controller;

import com.demo.Service.FeginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 孙小云
 * @version 1.0
 * @date 2019/8/7 10:16
 **/
@RestController
public class FeginController {

    @Autowired
    FeginService feginService;


    @GetMapping("/find")
    public List<Object>  getAll(){
        System.out.println(feginService.findAll());
        return feginService.findAll();
    }
}
