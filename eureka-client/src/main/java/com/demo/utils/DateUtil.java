package com.demo.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author 孙小云
 * @version 1.0
 * @date 2019/9/17 14:33
 **/
public class DateUtil {

    public static final SimpleDateFormat dayOfDateFormat = new SimpleDateFormat("YYYY-MM-dd");

    public static final SimpleDateFormat secondOfDateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm");


    //当前时间加1天
    public static String addOneDay(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH,1);
        return dayOfDateFormat.format(calendar.getTime());
    }

    //当前时间加一个月
    public static String addOneMonth(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH,1);
        return dayOfDateFormat.format(calendar.getTime());
    }

    //当前时间加上指定天数
    public static String addFewsDays(int num){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH,num);
        return dayOfDateFormat.format(calendar.getTime());
    }

    //提前指定时间
    public static String addFewsMin(Date date, int num){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE,-num);
        return secondOfDateFormat.format(calendar.getTime());
    }

    public static String dateToString(Date date){
        return dayOfDateFormat.format(date);
    }

    public static String datesToString(Date date){
        return secondOfDateFormat.format(date);
    }
}
