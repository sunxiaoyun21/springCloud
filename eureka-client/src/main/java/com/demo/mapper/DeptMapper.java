package com.demo.mapper;

import com.demo.entity.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

/**
 * @author 孙小云
 * @version 1.0
 * @date 2019/8/5 15:24
 **/
@Mapper
@Repository
public interface DeptMapper  extends BaseMapper<Dept> {


    @Select("select * from dept")
     List<Dept> findAll();

    @Select("select * from dept where deptno =#{deptno}")
    Dept queryDept(Long deptno);
}
