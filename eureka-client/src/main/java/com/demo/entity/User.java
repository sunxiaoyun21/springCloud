package com.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author 孙小云
 * @version 1.0
 * @date 2019/9/3 16:36
 **/
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class User {

    private Integer id;
    private String name;
    private String  gender;
    private String mobile;
    private Date creation;
}
