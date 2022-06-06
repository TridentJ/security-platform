/**
 * Created by IntelliJ IDEA.
 * User: trident
 * Date: 2022/5/21
 * Time: 22:29
 **/
package com.trident.security.service;

import com.trident.security.bean.SystemInfo;

import java.util.List;

public interface SystemInfoService {
    
    List<SystemInfo> getAllSystemInfo(Integer pageNum, Integer pageSize) throws Exception;
    List<SystemInfo> getAllActiveSystemInfo(Integer pageNum, Integer pageSize) throws Exception;
    SystemInfo getSystemInfoById(Integer id) throws Exception;
    List<SystemInfo> getSystemInfoByName(String name) throws Exception;
    
    
}
