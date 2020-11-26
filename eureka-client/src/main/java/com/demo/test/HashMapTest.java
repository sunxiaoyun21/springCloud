package com.demo.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * HashMap 的 7 种遍历方式
 * @author 孙小云
 * @version 4.0
 * @date 2020/11/20$ 13:42
 **/
public class HashMapTest {

    public static void main(String[] args) {
         Map<Integer,String> hashMap = getHashMap();

        //Streams API 多线程
        hashMap.entrySet().parallelStream().forEach(it->{

            System.out.println(it.getValue());
        });

       LinkedList linkedList = new LinkedList();



   /*    // Streams API单线程
        hashMap.entrySet().stream().forEach((it->{
            System.out.println(it.getKey());
            System.out.println(it.getValue());
        }));
*/

      /*   //Lambda
        hashMap.forEach((key,value)->{
            System.out.println(key);
            System.out.println(value);
        });*/

      /*   //ForEach KeySet
        for (Integer key :hashMap.keySet()){
            System.out.println(hashMap.get(key));
        }
        */

     /*   //ForEach EntrySet
       for (Map.Entry<Integer,String> entry: hashMap.entrySet()){
           System.out.println(entry.getKey());
        }*/


       /* //迭代器 KeySet
        Iterator<Integer> iterator  = hashMap.keySet().iterator();
        while (iterator.hasNext()){
            Integer key = iterator.next();
            System.out.println(hashMap.get(key));
        }*/

     /*   //迭代器 EntrySet
        Iterator<Map<Integer,String>> iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer,String> map = (Map.Entry<Integer, String>) iterator.next();
            System.out.println(map.getKey());
            System.out.println(map.getValue());
        }*/
    }























    public static Map getHashMap(){
        HashMap  map = new HashMap();
        map.put(1,"java");
        map.put(2,"python");
        map.put(3,"go");
        map.put(4,"js");
        return map;

    }
}
