package com.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Table;
import java.util.Date;

/**
 * @author sunxiaoyun
 * @date 2020/3/18 15:29
 */

@NoArgsConstructor
@Data
@Accessors(chain = true)
@Table(name = "sys_log")
public class Log {

    private Integer id;
    private int type ;
    private String title;
    private String createBy;
    private Date createDate;
    private String remoteAddr;
    private String userAgent;
    private String requestUri;
    private String method;
    private String params;
    private  String exception;

}
