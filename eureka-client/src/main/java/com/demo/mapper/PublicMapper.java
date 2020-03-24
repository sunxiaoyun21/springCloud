package com.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.HashMap;

/**
 * @author sunxiaoyun
 * @date 2020/3/24 9:19
 */
@Mapper
public interface PublicMapper {

    @Select("${sqlStr}")
    HashMap<String,Object> getPublicItems(@Param(value = "sqlStr") String sqlStr);
}
