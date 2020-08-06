package com.demo.test;

import com.demo.entity.akt.TAktCustomerCrmEntity;
import com.demo.mapper.CustomerCrmMapper;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author 孙小云
 * @version 4.0
 * @date 2020/7/23$ 16:43
 **/
public class Customer {


    public static void main(String[] args) {
        List<TAktCustomerCrmEntity> allData=new LinkedList<>();
        Map<String,List<TAktCustomerCrmEntity>> allDataMap=allData.stream().collect(Collectors.groupingBy(TAktCustomerCrmEntity::getIdentifyNo));
        List<String> ids=new LinkedList<>();
        allDataMap.forEach((key,value)->{
            if(value.size()>1){
                ids.addAll(value.stream().map(TAktCustomerCrmEntity::getId).collect(Collectors.toList()));
            }
        });
        System.out.println("重复的记录ID:"+ids);
    }

}
