package com.demo.test;

import com.demo.entity.Message;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * java反射
 * @author 孙小云
 * @version 4.0
 * @date 2020/7/3$ 11:40
 **/
public class DumpMethods {

    public static void main(String[] args) {
        try {
            Class cls1 = Message.class;
            Object o = cls1.newInstance();

            Class c = Class.forName("java.util.Stack");
            Method method[] = c.getDeclaredMethods();
            Method m[] = c.getMethods();
            for (int i =0;i<method.length;i++){
                System.out.println(method[i].toString());
            }
            System.out.println("-----------------------------");
          /*  Arrays.stream(m).forEach(i->{
                System.out.println(i.toString());
            });*/
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
