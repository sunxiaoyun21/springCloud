package com.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Table;
import java.util.Date;

/**
 * @author 孙小云
 * @version 1.0
 * @date 2019/9/18 10:07
 **/
@Data
@NoArgsConstructor
@Accessors(chain = true)
@Table(name = "channel_resume_template")
public class ChannelResumeTemplate {


    private int id;
    private int channelId;
    private int userId;
    private Date creationTime;
    private Date modifyTime;
}
