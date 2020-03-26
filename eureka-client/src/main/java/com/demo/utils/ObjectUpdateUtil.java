package com.demo.utils;

import com.demo.entity.Dept;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sunxiaoyun
 * @date 2020/3/25 14:38
 */
public class ObjectUpdateUtil {


    public static StringBuilder compareContract(Object sign, Object existSign) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            Field[] fields = getAllFields(sign);
            for (int j = 0; j < fields.length; j++) {
                fields[j].setAccessible(true);
                // 字段值
                if (!fields[j].get(sign).equals(fields[j].get(existSign))) {
                    stringBuilder.append(fields[j].getName() + "、");
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return stringBuilder;
    }


    /**
     * 获取所有属性，包括父类
     *
     * @param object
     * @return
     */
    public static Field[] getAllFields(Object object) {
        Class clazz = object.getClass();
        List<Field> fieldList = new ArrayList<>();
        while (clazz != null) {
            fieldList.addAll(new ArrayList<>(Arrays.asList(clazz.getDeclaredFields())));
            clazz = clazz.getSuperclass();
        }
        Field[] fields = new Field[fieldList.size()];
        fieldList.toArray(fields);
        return fields;
    }


    public static void main(String[] args) {
        Dept dept1 = new Dept().setDeptno(1L).setDname("zjamh").setDb_source("ceshi");
        Dept dept2 = new Dept().setDeptno(1L).setDname("zhangsan").setDb_source("xiy");
        String[] ss = compareContract(dept1,dept2).toString().split("、");
        Arrays.stream(ss).forEach(it->{
            System.out.println(it);
        });

    }
}

