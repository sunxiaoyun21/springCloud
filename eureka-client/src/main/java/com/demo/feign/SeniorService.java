package com.demo.feign;

import com.demo.entity.Senior;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.LinkedList;
import java.util.List;

/**
 * @author 孙小云
 * @version 1.0
 * @date 2019/8/7 11:26
 **/
@FeignClient("eureka-consumer")
public interface SeniorService {

    @GetMapping("/senior/findAll")
    List<Senior> findAll();
}
