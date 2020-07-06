package com.demo.fegin;

import com.demo.service.impl.MessageServiceFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author 孙小云
 * @version 1.0
 * @date 2019/8/7 11:26
 **/
@FeignClient(name = "eureka-client", fallback = MessageServiceFallback.class)
public interface MessageService {

    @GetMapping("/message/getMessage")
    String getMsg();

    @GetMapping("/message/findMesById/{id}")
    String findMesById(@PathVariable("id") Integer id);
}
