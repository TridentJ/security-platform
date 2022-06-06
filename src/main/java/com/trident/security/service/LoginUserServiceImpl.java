/**
 * Created by IntelliJ IDEA.
 * User: trident
 * Date: 2022/05/20
 * Time: 19:58
 **/
package com.trident.security.service;

import com.trident.security.bean.LoginUser;
import com.trident.security.bean.LoginUserExample;
import com.trident.security.dao.LoginUserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("loginUser")
public class LoginUserServiceImpl implements LoginUserService {
    
    @Resource
    private LoginUserMapper loginUserMapper;
    
    @Override
    public List<LoginUser> getAllUser() throws Exception {
        LoginUserExample loginUserExample = new LoginUserExample();
        loginUserExample.createCriteria().andIdGreaterThan(0);
        loginUserExample.setOrderByClause("id desc");
        List<LoginUser> loginUserList = loginUserMapper.selectByExample(loginUserExample);
        return loginUserList;
    }
    
    @Override
    public List<LoginUser> getUserByUserTypeAndStatus(Integer userType,Integer status) throws Exception {
        LoginUserExample loginUserExample = new LoginUserExample();
        LoginUserExample.Criteria criteria = loginUserExample.createCriteria();
        criteria.andIdGreaterThan(0);
        if(userType > 0){
            criteria.andUserTypeEqualTo(userType);
        }
        if(status > 0){
            criteria.andStatusEqualTo(status);
        }
        //loginUserExample.createCriteria().andIdGreaterThan(0).andUserTypeEqualTo(userType).andStatusEqualTo(status);
        loginUserExample.setOrderByClause("id desc");
        List<LoginUser> loginUserList = loginUserMapper.selectByExample(loginUserExample);
        return loginUserList;
    }
    
    @Override
    public LoginUser getUserById(Integer id) throws Exception {
        
        return loginUserMapper.selectByPrimaryKey(id);
    }
    
    
    @Override
    public Long getAllCount() throws Exception {
        LoginUserExample loginUserExample = new LoginUserExample();
        loginUserExample.createCriteria().andIdGreaterThan(-1);
        return loginUserMapper.countByExample(loginUserExample);
    }
}
