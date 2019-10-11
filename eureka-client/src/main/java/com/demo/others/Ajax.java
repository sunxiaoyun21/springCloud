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

    private int code;

    private String message;

    private T data;


}
