package com.demo.utils;

import java.io.*;
import java.lang.reflect.Field;
import java.util.List;
import java.util.UUID;

/**
 * @author 孙小云
 * @version 1.0
 * @date 2019/9/18 16:45
 **/
public class CsvUtil {

    /**
     *
     * @param header 内容标题
     * @param data  要导出的数据集合
     * @return
     */
    public static String  exportCSV(List<String> headers, List<String> propertys ,List<?> datas) throws IOException, IllegalAccessException {

        UUID uuid = UUID.randomUUID();
        String uu = uuid.toString();
        File file = new File("d:\\test"+uu+".csv");
        //构建输出流，同时指定编码
        OutputStreamWriter ow = new OutputStreamWriter(new FileOutputStream(file), "gbk");

        //csv文件是逗号分隔，除第一个外，每次写入一个单元格数据后需要输入逗号
        for (String title : headers) {
            ow.write(title);
            ow.write(",");
        }
        //写完文件头后换行
        ow.write("\r\n");
        //写内容
        for (Object obj : datas) {
            //利用反射获取所有字段
            Field[] fields = obj.getClass().getDeclaredFields();
            for (String property : propertys) {
                for (Field field : fields) {
                    //设置字段可见性
                    field.setAccessible(true);
                    if (property.equals(field.getName())) {
                        ow.write(field.get(obj).toString());
                        ow.write(",");
                        continue;
                    }
                }
            }
            //写完一行换行
            ow.write("\r\n");
        }
        ow.flush();
        ow.close();
        return "0";

    }
}
