package com.demo.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WriteErrorLogUtil {

    public static void writeEror_to_txt(String path,String content) throws IOException {

        File F=new File(path);
        //如果文件不存在,就动态创建文件
        if(!F.exists()){
            F.createNewFile();
        }
        FileWriter fw=null;

        String writeDate="时间:"+DateUtil.datesToString(new Date())+"---"+"错误信息:"+content;
        try {
            //设置为:True,表示写入的时候追加数据
            fw=new FileWriter(F, true);
            //回车并换行
            fw.write(writeDate+"\r\n");
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(fw!=null){
                fw.close();
            }
        }

    }


    public static void main(String[] args) throws IOException {
        String path="D:/filezl.txt";
        String content = null;

        try {
            List<String> list=new ArrayList<>();
            list.add("1");
            list.add("2");
            list.add("3");
            list.forEach(it->{
                System.out.printf(it);
            });
            String j=list.get(3);
        } catch (Exception e) {
            content=e.getClass().getName()+"  error Info  "+e.getMessage();
        }
        writeEror_to_txt(path,content);
    }

}
