package com.demo.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Table;

/**
 * @author 孙小云
 * @version 4.0
 * @date 2020/7/2$ 16:31
 **/
@Data
@Accessors(chain = true)
@Table(name = "message")
public class Message {

    private Integer id;
    private String message;
}
