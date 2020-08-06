package com.demo.service.akt;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.demo.entity.Senior;
import com.demo.entity.akt.TAktCustomerCrmEntity;
import com.demo.feign.SeniorService;
import com.demo.mapper.CustomerCrmMapper;

import com.demo.utils.UUIDUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 *  服务实现类
 *
 * @author sunxiaoyun
 * @date 2020-07-23
 */
@Service
@Slf4j
public class TAktCustomerCrmServiceImpl {



    @Autowired
    CustomerCrmMapper customerCrmMapper;

    @Autowired
    SeniorService seniorService;


    public void update() {
        List<Senior> idCards = seniorService.findAll();
        Map<String,List<Senior>> idCardsDataMap=idCards.stream().collect(Collectors.groupingBy(Senior::getIdCard));
        LinkedList<TAktCustomerCrmEntity> allData = customerCrmMapper.findAll();
        Map<String,List<TAktCustomerCrmEntity>> allDataMap=allData.stream().collect(Collectors.groupingBy(TAktCustomerCrmEntity::getIdentifyNo));
        List<String> ids=new LinkedList<>();
        idCardsDataMap.forEach((key,value)-> {
            if (!allDataMap.containsKey(key)) {
                ids.add(key);
            }
            ;
        });
        System.out.println(ids);
        List<Senior> seniors = new ArrayList<>();
        ids.forEach(id->{
            if(idCardsDataMap.containsKey(id)){
                seniors.addAll(idCardsDataMap.get(id)) ;
                System.out.println(idCardsDataMap.get(id));
            }
        });

     seniors.forEach(it->{
         List<TAktCustomerCrmEntity> customer = customerCrmMapper.select(new TAktCustomerCrmEntity().setIdentifyNo(it.getIdCard()).setDelFlag("0"));
         if( customer.size()==0){
             TAktCustomerCrmEntity customerCrmEntity = new TAktCustomerCrmEntity();
             customerCrmEntity.setId(UUIDUtil.generateUuid());
             customerCrmEntity.setIdentifyNo(it.getIdCard());
             customerCrmEntity.setCustomerName(it.getName());
             customerCrmEntity.setCustomerAddress(it.getAddress());
             customerCrmEntity.setCustomerSex(it.getSex());
             customerCrmEntity.setDelFlag("0");
             customerCrmMapper.insertSelective(customerCrmEntity);
         }

     });
        System.out.println(seniors.size()+"-------------------------");





            //Map<String, Object> map = idCards.stream().collect(Collectors.toMap(v -> v, v -> v));
            //LinkedList<String> allData = customerCrmMapper.findAllIdCard();
            //Map<String, String> map1 = allData.stream().collect(Collectors.toMap(v -> v, v -> v));
            //List<String> ids=new LinkedList<>();
  /*      map1.forEach((key,value)->{
           if(!map.containsKey(key)){
               ids.add(value);
           };
        });*/
   /*     System.out.println("重复数量"+ids.size());
        System.out.println(ids);*/
      /*  ids.forEach(id->{
           //customerCrmMapper.updateById(id);
            customerCrmMapper.updateByIdCard(id);
           log.info("结束删除id------"+id);
       });
*/


       /* LinkedList<TAktCustomerCrmEntity> allData = customerCrmMapper.findAll();
        Map<String,List<TAktCustomerCrmEntity>> allDataMap=allData.stream().collect(Collectors.groupingBy(TAktCustomerCrmEntity::getIdentifyNo));
        List<String> ids=new LinkedList<>();
        allDataMap.forEach((key,value)->{

//            if(value.size()>1){
//                for(int i=1;i<value.size();i++){
//                    ids.add(value.get(i).getId());
//                }
//
//                //ids.addAll(value.stream().map(TAktCustomerCrmEntity::getIdentifyNo).collect(Collectors.toList()));
//            }
        });
        System.out.println("重复的记录ID:"+ids);*/

       /* ids.forEach(id->{
           customerCrmMapper.updateById(id);
           log.info("结束删除id------"+id);
       });*/

            //log.info("删除完成-----------------");


        }


    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("name","张三");
        map.put("name","李四");
        map.put("me","王二");
        map.put("na","王源");
        map .entrySet().forEach(key -> {
            String val = map.get(key);
            System.out.println("val = " + val);
        });

    }

}
