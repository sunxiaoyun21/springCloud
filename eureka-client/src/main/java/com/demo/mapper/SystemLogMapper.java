package com.demo.mapper;

import com.demo.entity.Log;
import org.apache.ibatis.annotations.Mapper;
import tk.mybatis.mapper.common.BaseMapper;

/**
 * @author sunxiaoyun
 * @date 2020/3/18 17:05
 */
@Mapper
public interface SystemLogMapper extends BaseMapper<Log> {
}
