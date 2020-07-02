package com.demo.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author 孙小云
 * @version 1.0
 * @date 2019/8/7 11:26
 **/
@FeignClient("eureka-client")
public interface FeginService {

    @GetMapping("/dept/list")
    List<Object> findAll();
}
