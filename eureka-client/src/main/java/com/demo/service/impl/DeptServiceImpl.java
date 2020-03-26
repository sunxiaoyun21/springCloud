package com.demo.service.impl;

import com.demo.annotation.SystemControllerLog;
import com.demo.annotation.SystemGetLog;
import com.demo.entity.Dept;
import com.demo.mapper.DeptMapper;
import com.demo.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 孙小云
 * @version 1.0
 * @date 2019/8/5 15:25
 **/
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    DeptMapper deptMapper;

    @Override
    public List<Dept> findAll() {
        return deptMapper.selectAll();
    }

    @Override
    @SystemControllerLog(module="部门模块",methods="名称修改",serviceClass="DeptService",queryMethod="queryDept",parameterType="Long",parameterKey="deptno",tableName ="dept" )
    public boolean update(Dept dept) {
        return deptMapper.updateByPrimaryKeySelective(dept)>0;
    }

    @Override
    @SystemGetLog(parameterKey = "deptno",objectName = "Dept")
    public Dept queryDept(Long deptno) {
        return deptMapper.queryDept(deptno);
    }


}
