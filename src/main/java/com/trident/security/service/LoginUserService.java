/**
 * Created by IntelliJ IDEA.
 * User: trident
 * Date: 2022/05/20
 * Time: 19:56
 **/
package com.trident.security.service;

import com.trident.security.bean.LoginUser;

import java.util.List;

public interface LoginUserService {
    
    List<LoginUser> getAllUser() throws Exception;
    List<LoginUser> getUserByUserTypeAndStatus(Integer userType,Integer status) throws Exception;
    LoginUser getUserById(Integer id) throws Exception;
    Long getAllCount() throws Exception;
    
}
