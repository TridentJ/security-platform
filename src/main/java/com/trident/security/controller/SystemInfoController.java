/**
 * Created by IntelliJ IDEA.
 * User: trident
 * Date: 2022/6/3
 * Time: 21:39
 **/
package com.trident.security.controller;

import com.trident.security.bean.SystemInfo;
import com.trident.security.service.SystemInfoService;
import com.trident.security.service.SystemLogService;
import com.trident.security.utils.response.Response;
import com.trident.security.utils.systemInfo.SystemInfoSample;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Api(tags = "业务系统")
@RestController
@RequestMapping("api/system-info/")
public class SystemInfoController {

    @Resource
    private SystemInfoService systemInfoService;
    @Resource
    private SystemLogService systemLogService;
    
    @ApiOperation(value="获取业务系统名称清单")
    @GetMapping("/list-name")
    public Response getSystemInfoList(){
        Response response = new Response();
        try {
            List<SystemInfo> systemInfoList = systemInfoService.getAllActiveSystemInfo(1,1000);
            if(systemInfoList.isEmpty()){
                response.setCode(1201);
                response.setMessage("结果为空");
                return response;
            }
            List<SystemInfoSample> systemInfoSampleList = new ArrayList<>();
            Iterator<SystemInfo> iterator = systemInfoList.iterator();
            SystemInfo systemInfo = null;
            while (iterator.hasNext()){
                systemInfo = iterator.next();
                SystemInfoSample systemInfoSample = new SystemInfoSample();
                systemInfoSample.setId(systemInfo.getId());
                systemInfoSample.setName(systemInfo.getName());
                systemInfoSampleList.add(systemInfoSample);
            }
            response.setCode(0);
            response.setMessage("OK");
            response.setContent(systemInfoSampleList);
        
        }catch (Exception e){
            response.setCode(1002);
            response.setMessage("数据处理失败");
            systemLogService.addSystemLog("业务系统模块","getSystemInfoList",2,"数据处理失败！" + e.toString());
        }
        return  response;
    }
    
}
