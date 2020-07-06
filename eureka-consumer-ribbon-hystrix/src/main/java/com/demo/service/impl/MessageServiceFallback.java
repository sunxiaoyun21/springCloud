package com.demo.service.impl;

import com.demo.fegin.MessageService;
import org.springframework.stereotype.Component;

/**
 * @author 孙小云
 * @version 4.0
 * @date 2020/7/2$ 17:34
 **/
@Component
public class MessageServiceFallback  implements MessageService {


    @Override
    public String getMsg() {
        System.out.println("调用消息接口失败，对其进行降级处理！");
        return "消息接口繁忙，请稍后重试！";
    }

    @Override
    public String findMesById(Integer id) {
        return null;
    }
}
