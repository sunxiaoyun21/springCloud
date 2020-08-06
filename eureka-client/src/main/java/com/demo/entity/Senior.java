package com.demo.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Table;

/**
 * @author 孙小云
 * @version 4.0
 * @date 2020/7/23$ 14:10
 **/
@Data
@Accessors(chain = true)
public class Senior {

    private String idCard;
    private String name;
    private String sex;
    private  String address;
}
