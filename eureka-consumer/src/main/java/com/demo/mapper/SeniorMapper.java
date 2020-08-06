package com.demo.mapper;

import com.demo.entity.Senior;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.LinkedList;
import java.util.List;

/**
 * @author 孙小云
 * @version 4.0
 * @date 2020/7/23$ 14:14
 **/

@Mapper
@Repository
public interface SeniorMapper extends BaseMapper<Senior> {
    @Select("select id_card as idCard ,name,sex,address from senior")
    List<Senior> findIdCard();
}
