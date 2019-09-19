package com.demo.controller;

import com.demo.service.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 孙小云
 * @version 1.0
 * @date 2019/9/18 17:04
 **/

@RestController
@RequestMapping("/data/")
public class ExcelController {

    @Autowired
    ExcelService excelService;

    @GetMapping("excel")
    public List exportExcel(@RequestParam String type){
        return  excelService.findJobHuntingByType(type);
    }
}
