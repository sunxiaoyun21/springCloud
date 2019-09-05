package com.demo.controller;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.demo.properties.SmsProperties;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author 孙小云
 * @version 1.0
 * @date 2019/9/3 17:48
 **/
@RestController
public class SmsController {

    @Autowired
    SmsProperties smsProperties;

    private  String SignName ="test";
    private String templateCode = "SMS_153055065";

    @PostMapping("/sendSms")
    public String sendSms(@RequestParam String mobile){
        String ss = smsProperties.getAccessKeyId();
        IClientProfile profile = DefaultProfile.getProfile("default",smsProperties.getAccessKeyId(),smsProperties.getAccessSecret());
        IAcsClient client = new DefaultAcsClient(profile);
        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "default");
        request.putQueryParameter("PhoneNumbers", mobile);
        request.putQueryParameter("SignName", SignName);
        request.putQueryParameter("TemplateCode", templateCode);
        Map map =new HashMap();
        map.put("code",String.valueOf(random(6)));
        String jsonStr = JSON.toJSONString( map );

        request.putQueryParameter("TemplateParam",jsonStr);
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response);
            return  response.getData();
        } catch (ClientException e) {
            e.printStackTrace();
            return "发送失败";
        }

    }

    /**
     * 产生随机数(纯数字)
     */
    public  int random(int length) {
        Assert.isTrue(length > 0 && length < 9, "长度范围(1-8)");
        int start = (int) Math.pow(10, length - 1);
        int end = (int) Math.pow(10, length);
        ThreadLocalRandom random = ThreadLocalRandom.current();
        return random.nextInt(start, end);
    }
}
