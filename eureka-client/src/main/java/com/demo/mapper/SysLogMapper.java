package com.demo.mapper;

import com.demo.entity.SysLog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.BaseMapper;

/**
 * @author sunxiaoyun
 * @date 2020/3/23 14:26
 */
@Mapper
@Repository
public interface SysLogMapper extends BaseMapper<SysLog> {

}
