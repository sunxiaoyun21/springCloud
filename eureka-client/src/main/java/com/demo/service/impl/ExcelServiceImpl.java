package com.demo.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.demo.entity.DataJobHunting;
import com.demo.mapper.ExcelMapper;
import com.demo.service.ExcelService;
import com.demo.utils.CsvUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.ObjectUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * @author 孙小云
 * @version 1.0
 * @date 2019/9/18 17:10
 **/
@Service
public class ExcelServiceImpl implements ExcelService {

    @Autowired
    ExcelMapper excelMapper;

    @Override
    public List<String>  findJobHuntingByType(String type) {
        int jobType;
        if("兼职".equals(type)){
            jobType=0;
        }else if ("实习".equals(type)){
            jobType=2;
        }else {
            jobType=1;
        }

        List<String> jobhuntings =excelMapper.findJobHuntingByType(type);
        Map<String,Integer> data = new HashMap<>(100);
        List<String> jobs = new LinkedList<>();
        jobhuntings.forEach(obj->{
            JSONArray jobTypes= JSON.parseArray(obj);
            jobTypes.forEach(it->{
                jobs.add(it.toString()) ;
            });

        });
        jobs.forEach(job->{
            if(!job.isEmpty()){
                if(data.containsKey(job)){
                    data.put(job,data.get(job)+1);
                }else {
                    data.put(job,1);
                }
            }
        });
        List<DataJobHunting> dataJobHuntings = new ArrayList<>(data.size());
        data.forEach((title,num)->{
            int allnum = excelMapper.findPostNum(title,jobType,true);
            int nums = excelMapper.findPostNum(title,jobType,false);
            DataJobHunting dataJobHunting = new DataJobHunting();
            dataJobHunting.setTitle(title);
            dataJobHunting.setNum(num);
            dataJobHunting.setPostAllNum(allnum);
            dataJobHunting.setPostNum(nums);
            dataJobHuntings.add(dataJobHunting);
        });
       List titles = Arrays.asList("标题","数量","全部","上架");
       List propertys = Arrays.asList("title","num","postAllNum","postNum");
        try {
            Collections.sort(dataJobHuntings, new Comparator<DataJobHunting>() {
                public int compare(DataJobHunting u1, DataJobHunting u2) {
                    return new Double(u2.getNum()).compareTo(new Double(u1.getNum())); //升序

                }
            });

            CsvUtil.exportCSV(titles,propertys,dataJobHuntings);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

      return jobs;
    }


   public  Map getMap(Map map){

       List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
       Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
           public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
               return (o1.getValue() - o2.getValue());
           }
       });

        return map;
   }

    public static void main(String[] args) {
        String ss="[\"其他\"]";
        List list =new ArrayList();
        JSONArray jobTypes= JSON.parseArray(ss);
        jobTypes.forEach(it->{
            list.add(it.toString()) ;
        });
        System.out.println(list);
    }

}
