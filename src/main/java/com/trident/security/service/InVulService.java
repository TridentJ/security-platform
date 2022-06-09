/**
 * Created by IntelliJ IDEA.
 * User: trident
 * Date: 2022/05/20
 * Time: 19:30
 **/
package com.trident.security.service;


import com.trident.security.bean.InVul;

import java.util.Date;
import java.util.List;

public interface InVulService {
    
    List<InVul> getAllInVul(Integer pageNum, Integer pageSize) throws Exception;
    List<InVul> getAllActiveInVul(Integer pageNum, Integer pageSize) throws Exception;
    List<InVul> getAllInVulByStatus(Integer status,Integer pageNum, Integer pageSize) throws Exception;
    InVul getInVulById(Long id) throws Exception;
    List<InVul> getInVulByExample(InVul inVul, Date createEndTime, Date expectEndTime, Integer pageNum, Integer pageSize) throws Exception;
    
    Integer addInVul(InVul invul) throws Exception;
    Integer updateInVul(InVul inVul) throws Exception;
    Integer deleteInVulById(Long id) throws Exception;
    Integer changeStatusById(Long id,Integer status) throws Exception;
    
    Integer getAllCount() throws Exception;
    Integer getAvailableCountByStatus(Integer status) throws Exception;
    

}
