package com.demo.mapper;

import com.demo.entity.akt.TAktCustomerCrmEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.LinkedList;
import java.util.List;

/**
 * @author 孙小云
 * @version 4.0
 * @date 2020/7/23$ 15:59
 **/

@Mapper
@Repository
public interface CustomerCrmMapper extends BaseMapper<TAktCustomerCrmEntity> {


    @Select("select id,identify_no as identifyNo from t_akt_customer_crm where del_flag = 0 ")
    LinkedList<TAktCustomerCrmEntity> findAll();

    @Update("update t_akt_customer_crm set del_flag =1 where id =#{id}")
    void updateById(String id);

    @Select("select identify_no as identifyNo from t_akt_customer_crm where del_flag = 0 ")
    LinkedList<String> findAllIdCard();

    @Update("update t_akt_customer_crm set del_flag =1 where identify_no =#{id}")
    void updateByIdCard(String id);
}
