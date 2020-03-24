package com.demo.controller;

import com.demo.log.SystemLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sunxiaoyun
 * @date 2020/3/23 9:45
 */
@RestController
@RequestMapping("/log")
@Slf4j
public class SysLogController {


    @PostMapping
    @SystemLog("测试一下")
    public Object aop(String name, String nick) {
        Map<String, Object> map =new HashMap<>();
        log.info("我被执行了！");
        map.put("res", "ok");
        return map;
    }

    @PutMapping
    @SystemLog("修改数据")
    public Object update(String name) {
        Map<String, Object> map =new HashMap<>();
        log.info("我被执行了！");
        map.put("res", "ok");
        return map;
    }

}
