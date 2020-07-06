package com.demo.mapper;

import com.demo.entity.Message;
import org.apache.ibatis.annotations.Mapper;
import tk.mybatis.mapper.common.BaseMapper;

/**
 * @author 孙小云
 * @version 4.0
 * @date 2020/7/2$ 16:37
 **/
@Mapper
public interface MessageMapper extends BaseMapper<Message> {
}
