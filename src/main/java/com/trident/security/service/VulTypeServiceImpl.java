/**
 * Created by IntelliJ IDEA.
 * User: trident
 * Date: 2022/05/21
 * Time: 14:23
 **/
package com.trident.security.service;

import com.github.pagehelper.PageHelper;
import com.trident.security.bean.VulType;
import com.trident.security.bean.VulTypeExample;
import com.trident.security.dao.VulTypeMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("vulTypeService")
public class VulTypeServiceImpl implements VulTypeService {
    
    @Resource
    private VulTypeMapper vulTypeMapper;
    
    @Override
    public List<VulType> getAllVulType(Integer pageNum, Integer pageSize) throws Exception {
        VulTypeExample vulTypeExample = new VulTypeExample();
        vulTypeExample.createCriteria().andIdGreaterThan(0);
        PageHelper.startPage(pageNum,pageSize);
        return vulTypeMapper.selectByExample(vulTypeExample);
    }
    
    @Override
    public List<VulType> getAllActiveVulType(Integer pageNum, Integer pageSize) throws Exception {
        VulTypeExample vulTypeExample = new VulTypeExample();
        vulTypeExample.createCriteria().andIdGreaterThan(0).andStatusEqualTo(1);
        PageHelper.startPage(pageNum,pageSize);
        return vulTypeMapper.selectByExample(vulTypeExample);
    }
    
    @Override
    public String getVulTypeById(Integer id) throws Exception {
        VulType vulType = vulTypeMapper.selectByPrimaryKey(id);
        if(vulType != null){
            return vulType.getName();
        }
        return null;
    }
    
    @Override
    public Integer addVulType(String name) throws Exception {
        VulType vulType = new VulType();
        vulType.setName(name);
        return vulTypeMapper.insert(vulType);
    }
    
    @Override
    public Integer updateVulType(VulType vulType) throws Exception {
        
        return vulTypeMapper.updateByPrimaryKey(vulType);
    }
    
    @Override
    public Integer getAllCount() throws Exception {
        VulTypeExample vulTypeExample = new VulTypeExample();
        vulTypeExample.createCriteria().andIdGreaterThan(0);
        Long size = vulTypeMapper.countByExample(vulTypeExample);
        return size.intValue();
    }
}
