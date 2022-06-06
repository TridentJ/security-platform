/**
 * Created by IntelliJ IDEA.
 * User: trident
 * Date: 2022/5/21
 * Time: 22:44
 **/
package com.trident.security.service;

import com.github.pagehelper.PageHelper;
import com.trident.security.bean.SystemInfo;
import com.trident.security.bean.SystemInfoExample;
import com.trident.security.dao.SystemInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("systemInfoService")
public class SystemInfoServiceImpl implements SystemInfoService{
    @Resource
    private SystemInfoMapper systemInfoMapper;
    
    @Override
    public List<SystemInfo> getAllSystemInfo(Integer pageNum, Integer pageSize) throws Exception {
        SystemInfoExample systemInfoExample = new SystemInfoExample();
        systemInfoExample.createCriteria().andIdGreaterThan(0);
        systemInfoExample.setOrderByClause("id desc");
        PageHelper.startPage(pageNum,pageSize);
        return systemInfoMapper.selectByExample(systemInfoExample);
    }
    
    @Override
    public List<SystemInfo> getAllActiveSystemInfo(Integer pageNum, Integer pageSize) throws Exception {
        SystemInfoExample systemInfoExample = new SystemInfoExample();
        systemInfoExample.createCriteria().andIdGreaterThan(0).andStatusEqualTo(1);
        systemInfoExample.setOrderByClause("id desc");
        PageHelper.startPage(pageNum,pageSize);
        return systemInfoMapper.selectByExample(systemInfoExample);
    }
    
    @Override
    public SystemInfo getSystemInfoById(Integer id) throws Exception {
        return systemInfoMapper.selectByPrimaryKey(id);
    }
    
    @Override
    public List<SystemInfo> getSystemInfoByName(String name) throws Exception {
        SystemInfoExample systemInfoExample = new SystemInfoExample();
        systemInfoExample.createCriteria().andNameEqualTo(name);
        return systemInfoMapper.selectByExample(systemInfoExample);
    }
    
    
    
    
}
