package com.demo.service;

/**
 * @author 孙小云
 * @version 1.0
 * @date 2019/9/17 15:05
 **/
public interface SendSmsService {

    String sendSms(String mobile);

    String timeSendMessage(String mobile);
}
