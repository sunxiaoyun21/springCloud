package com.demo.controller;

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


   @GetMapping("/findAccount")
   public List getAccount(){
        Account account = new Account();
        account.setName("zhang");
        account.setAge(3);
       Account account1 = new Account();
       account1.setName("zhang");
       account1.setAge(3);
        List<Account> accounts = new ArrayList<>();
        accounts.add(account);
        accounts.add(account1);

        JedisUtil.setList("account",accounts);
        return JedisUtil.getList("account",0,accounts.size()-1);
   }
}
