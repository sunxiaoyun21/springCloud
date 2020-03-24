package com.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Table;
import java.util.Date;

/**
 * @author sunxiaoyun
 * @date 2020/3/23 14:11
 */
@NoArgsConstructor
@Data
@Accessors(chain = true)
@Table(name = "log")
public class SysLog {


        private long id;

        /**用户id*/
        private Long userId;

        /**用户类型*/
        private int userType;

        /**操作模块*/
        private String module;

        /**操作类型*/
        private String method;

        /**操作前参数*/
        private String beforeParams;

        /**操作时请求参数*/
        private String operateParams;

        /**开始时间*/
        private Date startTime;

        /**结束时间*/
        private Date endTime;

        /**操作状态描述*/
        private int resultStatus;

        /**操作结果描述*/
        private String resultMsg;
}
