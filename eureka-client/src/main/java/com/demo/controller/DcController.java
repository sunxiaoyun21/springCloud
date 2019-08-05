package com.demo.controller;

import com.demo.entity.Dept;
import com.demo.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 孙小云
 * @version 1.0
 * @date 2019/8/5 15:10
 **/
@RestController
@RequestMapping("/dept")
public class DcController {

    @Autowired
    DeptService deptService;

    @GetMapping("/list")
    public List<Dept> findDept() {
        List<Dept> depts = deptService.findAll();
        System.out.println(depts);
        return depts;
    }
}
