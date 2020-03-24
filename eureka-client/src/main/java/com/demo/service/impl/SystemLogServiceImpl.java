package com.demo.service.impl;

import com.demo.entity.Log;
import com.demo.entity.SysLog;
import com.demo.mapper.SysLogMapper;
import com.demo.mapper.SystemLogMapper;
import com.demo.service.SystemLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author sunxiaoyun
 * @date 2020/3/18 17:03
 */
@Service
public class SystemLogServiceImpl implements SystemLogService {

    @Autowired
    private  SystemLogMapper systemLogMapper;
    @Autowired
    private SysLogMapper sysLogMapper;

    @Override
    public boolean saveLog(Log log) {
        return  systemLogMapper.insertSelective(log)>0;
    }

    @Override
    public boolean saveSysLog(SysLog sysLog) {
        return sysLogMapper.insertSelective(sysLog)>0;
    }


}
