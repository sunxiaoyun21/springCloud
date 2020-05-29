package com.demo;

import com.demo.utils.OtherUtil;
import com.demo.utils.UUIDUtil;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 孙小云
 * @date 2020/5/28 10:27
 **/
public class GetPictureName {

    public static List<String> getFileName(String path)
    {
        File file = new File(path);
       List<String> fileName = Arrays.asList(file.list());
        return fileName;
    }

    public static void getAllFileName(String path, ArrayList<String> fileName)
    {
        File file = new File(path);
        File [] files = file.listFiles();
        String [] names = file.list();
        if(names != null)
            fileName.addAll(Arrays.asList(names));
        for(File a:files)
        {
            if(a.isDirectory())
            {
                getAllFileName(a.getAbsolutePath(),fileName);
            }
        }
    }

    public static void updateName(String path) throws IOException {
        File file = new File(path);
        String newFile= path.substring(0, path.indexOf(".jpg"))+ OtherUtil.random(6) +".jpg";
        file.renameTo(new File(newFile));
        FileWriter fw=null;
        //设置为:True,表示写入的时候追加数据
        fw=new FileWriter(file, true);

    }

    public static void main(String[] args) throws IOException {
       /* String path="C:/Users/sunxi/Desktop/养老机构照片/广西医大仁爱养老服务中心";
        getFileName(path).forEach(it->{
            System.out.println(it);
        });*/
        String path = "C:/Users/sunxi/Pictures/timg.jpg";
        String newFile=path.substring(0, path.indexOf(".jpg"))+ OtherUtil.random(6) +".jpg";
        FileReader  fr=null;
        FileWriter fw=null;
        try {
            fr = new FileReader(path);
            fw = new FileWriter(newFile);
            fw.write(fr.read());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fr != null) {
                fr.close();
            }
            if (fw != null) {
                fw.close();
            }
        }

    }
}
