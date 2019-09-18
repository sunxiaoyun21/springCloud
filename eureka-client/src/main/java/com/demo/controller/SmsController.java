package com.demo.controller;


import com.demo.service.SendSmsService;
import com.demo.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;


/**
 * @author 孙小云
 * @version 1.0
 * @date 2019/9/3 17:48
 **/
@RestController
public class SmsController {



    @Autowired
    SendSmsService sendSmsService;


    @PostMapping("/sendSms")
    public String sendSms(@RequestParam String mobile){
       return sendSmsService.sendSms(mobile);

    }


    @PostMapping("/TimeSendMessage")
    public String TimeSendMessage(@RequestParam String mobile){

        return sendSmsService.timeSendMessage(mobile);
    }

    
}
