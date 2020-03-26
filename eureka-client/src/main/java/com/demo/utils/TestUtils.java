package com.demo.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;

/**
 * @author sunxiaoyun
 * @version 1.0
 * @date 2020/3/25 15:08
 **/
public class TestUtils {
    public static List<Result> compareContract(Object source, Object target) {
        if (source == null) {
            throw new RuntimeException("源对象不能为空");
        }
        if (target == null) {
            throw new RuntimeException("目标对象不能为空");
        }
        if (!source.getClass().equals(target.getClass())) {
            throw new RuntimeException("参数类型不一致");
        }
        List<Result> data = new LinkedList<>();
        for (Field sourceField : source.getClass().getDeclaredFields()) {
            Object oldValue = null;
            Object newValue = null;
            sourceField.setAccessible(true);
            try {
                oldValue = sourceField.get(source);
                newValue = sourceField.get(target);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            Result result=null;
            if(oldValue==null){
                if(newValue==null){
                    break;
                }else{
                   result= Result.builder().field(sourceField.getName()).newValue(newValue).build();
                }
            }else{
                if(newValue==null){
                    result= Result.builder().field(sourceField.getName()).oldValue(oldValue).build();
                }else{
                    if(!oldValue.toString().equals(newValue.toString())){
                        result= Result.builder().field(sourceField.getName()).oldValue(oldValue).newValue(newValue).build();
                    }
                }
            }
            if (result!=null) {
                data.add(result);
            }
        }
        return data;
    }

    @Builder
    @Setter
    @Getter
    @Accessors(chain = true)
    public static class Result {
        private String field;
        private Object oldValue;
        private Object newValue;
    }

    @Setter
    @Getter
    @Builder
    @Accessors(chain = true)
    public static class Goods {
        private String name;
        private Integer num;
        private Boolean test;
    }

    public static void main(String[] args) {
        Goods goods = Goods.builder().name("苹果").num(5).test(true).build();
        Goods goods1 = Goods.builder().name("橘子").test(true).build();
        String ss = JSONObject.toJSONString(goods);
        String ss1 = JSONObject.toJSONString(goods1);
        Object jsonObject = JSON.parseObject(ss);
        Object jsonObject1 = JSON.parseObject(ss1);
        List<Result> data = compareContract(jsonObject, jsonObject1);
        data.forEach(e -> {
            String resultJson = JSONObject.toJSONString(e);
            System.out.println(resultJson);
           //System.out.println(String.format("%s %s %s",e.getField(),e.getOldValue(),e.getNewValue()));
        });
    }
}
