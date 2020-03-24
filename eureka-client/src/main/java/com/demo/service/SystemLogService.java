package com.demo.service;

import com.demo.entity.Log;
import com.demo.entity.SysLog;

/**
 * @author sunxiaoyun
 * @date 2020/3/18 17:02
 */
public interface SystemLogService {

    boolean saveLog(Log log);

    boolean saveSysLog(SysLog sysLog);
}
