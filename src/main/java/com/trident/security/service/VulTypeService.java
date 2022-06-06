/**
 * Created by IntelliJ IDEA.
 * User: trident
 * Date: 2022/05/21
 * Time: 14:23
 **/
package com.trident.security.service;

import com.trident.security.bean.VulType;

import java.util.List;

public interface VulTypeService {
    
    List<VulType> getAllVulType(Integer pageNum,Integer pageSize) throws Exception;
    List<VulType> getAllActiveVulType(Integer pageNum,Integer pageSize) throws Exception;
    String getVulTypeById(Integer id) throws Exception;
    Integer addVulType(String name) throws Exception;
    Integer updateVulType(VulType vulType) throws Exception;
    Integer getAllCount() throws Exception;
    
}
