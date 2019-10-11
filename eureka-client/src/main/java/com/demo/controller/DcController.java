package com.demo.controller;

import com.alibaba.fastjson.JSON;
import com.demo.entity.Account;
import com.demo.entity.Dept;
import com.demo.service.DeptService;
import com.demo.utils.JedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 孙小云
 * @version 1.0
 * @date 2019/8/5 15:10
 **/
@RestController
@RequestMapping("/dept")
public class DcController {

    @Autowired
    DeptService deptService;

    @GetMapping("/list")
    public List<Dept> findDept() throws InterruptedException {
        //Thread.sleep(5000);
        List<Dept> depts = deptService.findAll();
        System.out.println(depts);
        return depts;
    }

    @GetMapping("/find")
    public String insertName(){
        JedisUtil.set("test","test");
        String ss = JedisUtil.get("test");
        return ss;

    }

   @GetMapping("/findList")
   public  List getList(){
      List list  = Arrays.asList("q","e","f","g","o");
       JedisUtil.setList("list",list);
       return JedisUtil.getList("list",0,list.size()-1);
   }


    @GetMapping("/addAccount")
    public String addAccount(){
        Account account = new Account();
        account.setAge(5);
        account.setName("小仙女");
        List list =new ArrayList();
        list.add(account);
        JedisUtil.setList("account",list);
        return "ok";
    }

   @GetMapping("/findAccount")
   public List getAccount(){
        Long size = JedisUtil.getSize("account");
        int len = Math.toIntExact(size)-1;
        List<String>  list = JedisUtil.getList("account",0,len);
       List<Account> accounts = new ArrayList<>();
        list.forEach(obj->{
            Account account = JSON.parseObject(obj,Account.class);
            accounts.add(account);
        });
    return  accounts;
   }

    @GetMapping("/delByValue")
   public  String  delByValue(){
      String value = "{\"age\":2,\"name\":\"zhangs\"}" ;
      JedisUtil.delByValue("account",value);
      return "ok";
   }

   @GetMapping("/del")
   public  String del(String key){
       JedisUtil.del("account");
       return "ok";
   }

    @GetMapping("/update")
   public String update(){
        String value = "{\"age\":2,\"name\":\"zhangs\"}" ;
        JedisUtil.lSet("account",0L,value);
        return "ok";
   }
}
