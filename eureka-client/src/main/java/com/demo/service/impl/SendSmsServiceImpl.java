package com.demo.service.impl;

import com.alibaba.fastjson.JSON;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.demo.properties.SmsProperties;
import com.demo.service.SendSmsService;
import com.demo.utils.OtherUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 孙小云
 * @version 1.0
 * @date 2019/9/17 15:05
 **/
@Service
public class SendSmsServiceImpl implements SendSmsService {

    @Autowired
    SmsProperties smsProperties;

    private  String SignName ="趣兼职";
    private String templateCode = "SMS_173246287";

    @Override
    public String  sendSms(String mobile) {
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
        map.put("code",String.valueOf(OtherUtil.random(6)));
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

    @Override
    public String timeSendMessage(String mobile) {

        return null;
    }
}
