package com.demo.others;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author 孙小云
 * @version 1.0
 * @date 2019/10/10 15:29
 **/
@Data
@Accessors(chain = true)
public class Ajax<T> {

    /**
     * 状态码  200:成功  400:失败 202:等待中 401:未授权 403:权限不足
     */
    private int code;

    private String message;

    private T data;

    public static Ajax ok(){
        return new Ajax()
            .setCode(200)
            .setData("操作成功");

    }

  public static<T> Ajax<T> ok(T object){
     return new Ajax<T>()
         .setCode(200)
         .setData(object);
  }

  public static Ajax error(){
        return new Ajax()
            .setCode(400)
            .setData("操作失败");
  }

  public static Ajax status(int code,String message){
      return new Ajax()
          .setCode(400)
          .setMessage(message);
  }

  public static<T> Ajax<T> status(int code,T object){
        return new Ajax<T>()
            .setCode(code)
            .setData(object);
  }
}
