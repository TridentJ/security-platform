/**
 * Created by IntelliJ IDEA.
 * User: trident
 * Date: 2022/05/20
 * Time: 19:35
 **/
package com.trident.security.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trident.security.bean.InVul;
import com.trident.security.bean.InVulExample;
import com.trident.security.dao.InVulMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service("inVulService")
public class InVulServiceImpl implements InVulService {
    
    @Resource
    private InVulMapper inVulMapper;
    
    @Override
    public List<InVul> getAllInVul(Integer pageNum, Integer pageSize) throws Exception {
        InVulExample inVulExample = new InVulExample();
        inVulExample.createCriteria().andIdGreaterThan(0);
        inVulExample.setOrderByClause("id desc");
        PageHelper.startPage(pageNum,pageSize);
        return inVulMapper.selectByExample(inVulExample);
    }
    
    @Override
    public List<InVul> getAllActiveInVul(Integer pageNum, Integer pageSize) throws Exception {
        InVulExample inVulExample = new InVulExample();
        inVulExample.createCriteria().andIdGreaterThan(0).andVulStatusGreaterThan(0);
        inVulExample.setOrderByClause("id desc");
        PageHelper.startPage(pageNum,pageSize);
        return inVulMapper.selectByExample(inVulExample);
    }
    
    @Override
    public List<InVul> getAllInVulByStatus(Integer status,Integer pageNum, Integer pageSize) throws Exception {
        InVulExample inVulExample = new InVulExample();
        inVulExample.createCriteria().andVulStatusEqualTo(status);
        inVulExample.setOrderByClause("id desc");
        PageHelper.startPage(pageNum,pageSize);
        return inVulMapper.selectByExample(inVulExample);
    }
    
    @Override
    public InVul getInVulById(Integer id) throws Exception {
        return inVulMapper.selectByPrimaryKey(id);
    }
    
    @Override
    public List<InVul> getInVulByExample(InVul inVul, Date createEndTime, Date expectEndTime, Integer pageNum, Integer pageSize) throws Exception {
        InVulExample inVulExample = new InVulExample();
        InVulExample.Criteria criteria = inVulExample.createCriteria();
        if(inVul.getTitle() != null && inVul.getTitle().compareTo("") != 0){
            criteria.andTitleLike(inVul.getTitle());
        }
        if(inVul.getSerialNum() != null && inVul.getSerialNum().compareTo("") != 0){
            criteria.andSerialNumLike("%" + inVul.getSerialNum() + "%");
        }
        if(inVul.getVulType() != null){
            criteria.andVulTypeEqualTo(inVul.getVulType());
        }
        if(inVul.getRisk() != null){
            criteria.andRiskEqualTo(inVul.getRisk());
        }
        if(inVul.getVulStatus() != null){
            criteria.andVulStatusEqualTo(inVul.getVulStatus());
        }
        if(inVul.getFixStatus() != null){
            criteria.andFixStatusEqualTo(inVul.getFixStatus());
        }
        if(inVul.getContent() != null && inVul.getContent().compareTo("") != 0){
            criteria.andContentLike(inVul.getContent());
        }
        if(inVul.getUrl() != null && inVul.getUrl().compareTo("") != 0){
            criteria.andUrlLike(inVul.getContent());
        }
        if(inVul.getCreateTime() != null && createEndTime != null){
            criteria.andCreateTimeBetween(inVul.getCreateTime(),createEndTime);
        }
        if(inVul.getExpectTime() != null && expectEndTime != null){
            criteria.andExpectTimeBetween(inVul.getExpectTime(),expectEndTime);
        }
        if(inVul.getDepartment() != null){
            criteria.andDepartmentEqualTo(inVul.getDepartment());
        }
        inVulExample.setOrderByClause("id desc");
        PageHelper.startPage(pageNum,pageSize);
        return inVulMapper.selectByExample(inVulExample);
    }
    
    @Override
    public Integer addInVul(InVul invul) throws Exception {
        return inVulMapper.insertSelective(invul);
    }
    
    @Override
    public Integer updateInVul(InVul inVul) throws Exception {
        return inVulMapper.updateByPrimaryKeySelective(inVul);
    }
    
    @Override
    public Integer deleteInVulById(Integer id) throws Exception {
        return inVulMapper.deleteByPrimaryKey(id);
    }
    
    @Override
    public Integer changeStatusById(Integer id, Integer status) throws Exception {
        InVul inVul = new InVul();
        inVul.setVulStatus(status);
        inVul.setId(id);
        return inVulMapper.updateByPrimaryKeySelective(inVul);
    }
    
    @Override
    public Integer getAllCount() throws Exception {
        InVulExample inVulExample = new InVulExample();
        inVulExample.createCriteria().andIdGreaterThan(-1);
        Long size = inVulMapper.countByExample(inVulExample);
        return size.intValue();
    }
    
    @Override
    public Integer getAvailableCountByStatus(Integer status) throws Exception {
        InVulExample inVulExample = new InVulExample();
        inVulExample.createCriteria().andVulStatusEqualTo(status);
        Long size = inVulMapper.countByExample(inVulExample);
        return size.intValue();
    }
}
