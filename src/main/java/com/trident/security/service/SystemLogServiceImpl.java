/**
 * Created by IntelliJ IDEA.
 * User: trident
 * Date: 2022/5/21
 * Time: 14:46
 **/
package com.trident.security.service;

import com.github.pagehelper.PageHelper;
import com.trident.security.bean.SystemLog;
import com.trident.security.bean.SystemLogExample;
import com.trident.security.dao.SystemLogMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service("systemLogService")
public class SystemLogServiceImpl implements SystemLogService {
    @Resource
    private SystemLogMapper systemLogMapper;
    
    
    //private final static Logger logger = LoggerFactory.getLogger(SystemLogServiceImpl.class);
    
    @Override
    public List<SystemLog> getAllSystemLog(Integer pageNum, Integer pageSize) throws Exception {
        SystemLogExample systemLogExample = new SystemLogExample();
        systemLogExample.createCriteria().andIdGreaterThan(0);
        PageHelper.startPage(pageNum,pageSize);
        return systemLogMapper.selectByExample(systemLogExample);
    }
    
    @Override
    public List<SystemLog> getSystemLogByExample(SystemLog systemLog, Date endTime, Integer pageNum, Integer pageSize) throws Exception {
        SystemLogExample systemLogExample = new SystemLogExample();
        SystemLogExample.Criteria criteria =  systemLogExample.createCriteria();
        if(systemLog.getLogModule() != null && !systemLog.getLogModule().equals("")){
            criteria.andLogModuleEqualTo(systemLog.getLogModule());
        }
        if(systemLog.getMethod() != null && !systemLog.getMethod().equals("")){
            criteria.andMethodEqualTo(systemLog.getMethod());
        }
        if(systemLog.getLogType() != null && systemLog.getLogType() > 0){
            criteria.andLogTypeEqualTo(systemLog.getLogType());
        }
        if(systemLog.getLogType() != null && systemLog.getLogType() > 0){
            criteria.andLogTypeEqualTo(systemLog.getLogType());
        }
        if(systemLog.getCreateTime() != null && endTime != null){
            criteria.andCreateTimeBetween(systemLog.getCreateTime(),endTime);
        }
        PageHelper.startPage(pageNum,pageSize);
        List<SystemLog> systemLogList = systemLogMapper.selectByExample(systemLogExample);
        return systemLogList;
    }
    
    @Override
    public SystemLog getSystemLogById(Integer id) throws Exception {
        return systemLogMapper.selectByPrimaryKey(id);
    }
    
    @Override
    public Integer addSystemLog(SystemLog systemLog) {
        int result;
        try {
            result = systemLogMapper.insertSelective(systemLog);
            return result;
        }catch (Exception e){
            return 0;
        }
        
    }
    
    @Override
    public Integer addSystemLog(String logModule, String method, Integer logType, String msg) {
        int result = 0;
        SystemLog systemLog = new SystemLog();
        systemLog.setLogModule(logModule);
        systemLog.setMethod(method);
        systemLog.setLogType(logType);
        if(msg.length() > 255){
            systemLog.setMsg(msg.substring(0,255));
        }else{
            systemLog.setMsg(msg);
        }
        try {
            result =  systemLogMapper.insertSelective(systemLog);
        }catch (Exception e){
            e.printStackTrace();
            //logger.error("[SystemLogServiceImpl.addSystemLog]添加system-log出错！" + e.toString());
            return 0;
        }
        return result;
    }
}
