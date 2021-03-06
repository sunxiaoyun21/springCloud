package com.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.demo.annotation.SystemControllerLog;
import com.demo.annotation.SystemGetLog;
import com.demo.entity.Account;
import com.demo.entity.Dept;
import com.demo.others.Ajax;
import com.demo.service.DeptService;
import com.demo.utils.JedisUtil;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.sun.tools.classfile.Attribute.Code;

/**
 * @author 孙小云
 * @version 1.0
 * @date 2019/8/5 15:10
 **/
@RestController
@RequestMapping("/dept/")
public class DcController {

    @Autowired
    DeptService deptService;

    @GetMapping("list")
    public Ajax findDept() throws InterruptedException {
        //Thread.sleep(5000);
        List<Dept> depts = deptService.findAll();
        System.out.println(depts);
        return Ajax.ok(depts);
    }

    @GetMapping("findById")
    //@SystemGetLog(parameterKey = "deptno",objectName = "Dept")
    public Ajax findById(Long id){
        Dept dept = deptService.queryDept(id);
        return Ajax.ok(dept);
    }

    @PutMapping("update")
    public Ajax update(@RequestBody Dept dept){
        return Ajax.ok(deptService.update(dept));
    }

    @GetMapping("find")
    public Ajax insertName(){
        JedisUtil.set("test","test");
        String ss = JedisUtil.get("test");
        return Ajax.ok(ss);

    }

   @GetMapping("findList")
   public  List getList(){
      List list  = Arrays.asList("q","e","f","g","o");
       JedisUtil.setList("list",list);
       return JedisUtil.getList("list",0,list.size()-1);
   }


    @GetMapping("addAccount")
    public Ajax addAccount(){
        Account account = new Account();
        account.setAge(5);
        account.setName("小仙女");
        List list =new ArrayList();
        list.add(account);
        JedisUtil.setList("account",list);
        return Ajax.ok();
    }

   @GetMapping("findAccount")
   public Ajax getAccount(){
        Long size = JedisUtil.getSize("account");
        int len = Math.toIntExact(size)-1;
        List<String>  list = JedisUtil.getList("account",0,len);
       List<Account> accounts = new ArrayList<>();
        list.forEach(obj->{
            Account account = JSON.parseObject(obj,Account.class);
            accounts.add(account);
        });
    return  Ajax.ok(accounts);
   }

    @GetMapping("delByValue")
   public  Ajax  delByValue(){
      String value = "{\"age\":2,\"name\":\"zhangs\"}" ;
      JedisUtil.delByValue("account",value);
      return Ajax.ok();
   }

   @GetMapping("del")
   public  Ajax del(String key){
       JedisUtil.del("account");
       return Ajax.ok();
   }

  /*  @GetMapping("/update")
   public Ajax update(){
        String value = "{\"age\":2,\"name\":\"zhangs\"}" ;
        JedisUtil.lSet("account",0L,value);
        return Ajax.ok();
   }*/

    public static void main(String[] args) {
        List a =  new ArrayList();
        a.add(1);
        a.add(2);
        List b =  new ArrayList();
        a.add(5);
        a.add(8);
        a.addAll(b);
        System.out.println(a);
    }
}
