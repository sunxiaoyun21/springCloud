package com.demo.controller;

import com.demo.annotation.SystemLog;
import com.demo.service.akt.TAktCustomerCrmServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sunxiaoyun
 * @date 2020/3/23 9:45
 */
@RestController
@RequestMapping("/customer")
@Slf4j
public class CustomerController {

    @Autowired
    TAktCustomerCrmServiceImpl customerCrmService;

    @GetMapping
    public void update() {
        customerCrmService.update();
    }



}
