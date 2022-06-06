/**
 * Created by IntelliJ IDEA.
 * User: trident
 * Date: 2022/5/21
 * Time: 14:44
 **/

package com.trident.security.service;

import com.trident.security.bean.SystemLog;

import java.util.Date;
import java.util.List;

public interface SystemLogService {
    
    List<SystemLog> getAllSystemLog(Integer pageNum,Integer pageSize) throws Exception;
    List<SystemLog> getSystemLogByExample(SystemLog systemLog, Date endTime, Integer pageNum, Integer pageSize) throws Exception;
    SystemLog getSystemLogById(Integer id) throws Exception;
    Integer addSystemLog(SystemLog systemLog);
    Integer addSystemLog(String logModule,String method,Integer logType,String msg);
    
    
    
}
