package com.demo.service;

import com.demo.entity.Dept;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author 孙小云
 * @version 1.0
 * @date 2019/8/5 15:23
 **/
public interface DeptService {

    List<Dept> findAll();

    boolean update(Dept dept);

    Dept queryDept(Long deptno);

}
