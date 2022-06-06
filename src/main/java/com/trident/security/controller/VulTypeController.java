/**
 * Created by IntelliJ IDEA.
 * User: trident
 * Date: 2022/6/4
 * Time: 13:09
 **/
package com.trident.security.controller;

import com.trident.security.bean.VulType;
import com.trident.security.service.SystemLogService;
import com.trident.security.service.VulTypeService;
import com.trident.security.utils.response.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = "漏洞类型")
@RestController
@RequestMapping("api/vul-type")
public class VulTypeController {
    @Resource
    private VulTypeService vulTypeService;
    @Resource
    private SystemLogService systemLogService;
    
    @ApiOperation(value="获取漏洞类型清单")
    @GetMapping("/list")
    public Response getVulTypeList(){
        Response response = new Response();
        try {
            List<VulType> vulTypeList = vulTypeService.getAllActiveVulType(1,1000);
            if(vulTypeList.isEmpty()){
                response.setCode(1301);
                response.setMessage("结果为空");
                return response;
            }
            response.setCode(0);
            response.setMessage("OK");
            response.setContent(vulTypeList);
        }catch (Exception e){
            response.setCode(1002);
            response.setMessage("数据处理失败");
            systemLogService.addSystemLog("漏洞类型模块","getVulTypeList",2,"数据处理失败！" + e.toString());
            
        }
        return response;
    }

}
