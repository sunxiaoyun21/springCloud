package com.demo.controller;

import com.demo.entity.Message;
import com.demo.fegin.MessageService;
import com.demo.service.impl.ConsumerService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 孙小云
 * @version 4.0
 * @date 2020/7/2$ 11:03$
 **/
@RestController
@RequestMapping("/message/")
public class MessageCenterController {

    @Autowired
    ConsumerService consumerService;

    @Autowired
    MessageService messageService;

    @GetMapping("getMes")
    //@HystrixCommand(fallbackMethod = "getMsgFallback")
    public Object getMes(){
        String msg = messageService.getMsg();
        return msg;
    }

    @GetMapping("findMesById/{id}")
    //@HystrixCommand(fallbackMethod = "getMsgDetailFallback")
    public String findMesById(@PathVariable("id") Integer id){
        return messageService.findMesById(id);
    }



    public Object getMsgFallback() {
        return "heheheheh.失败。出错了啊！";
    }

    /**
     * 获取消息详情退路
     */
    public Message getDetailFallback(Long id){
        return null;
    }
}
