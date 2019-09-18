package com.demo.mapper;

import com.demo.entity.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

/**
 * @author 孙小云
 * @version 1.0
 * @date 2019/8/5 15:24
 **/
@Mapper
public interface DeptMapper  extends BaseMapper<Dept> {


    @Select("select * from dept")
     List<Dept> findAll();
}
