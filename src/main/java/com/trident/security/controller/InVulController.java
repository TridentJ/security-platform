/**
 * Created by IntelliJ IDEA.
 * User: trident
 * Date: 2022/5/20
 * Time: 22:58
 **/
package com.trident.security.controller;


import com.trident.security.bean.InVul;
import com.trident.security.bean.SystemInfo;
import com.trident.security.service.InVulService;
import com.trident.security.service.SystemInfoService;
import com.trident.security.service.SystemLogService;
import com.trident.security.service.VulTypeService;
import com.trident.security.utils.vul.InVulInfo;
import com.trident.security.utils.vul.InVulSample;
import com.trident.security.utils.response.Response;
import com.trident.security.utils.response.ResponseList;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.owasp.encoder.Encode;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Api(tags = "内部漏洞")
@RestController
@RequestMapping("api/vulnerabilities/internal")
public class InVulController {

    @Resource
    private SystemInfoService systemInfoService;
    @Resource
    private InVulService inVulService;
    @Resource
    private VulTypeService vulTypeService;
    @Resource
    private SystemLogService systemLogService;
    
    //private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    
    @ApiOperation(value="内部漏洞清单",notes = "内部漏洞展示页API")
    @GetMapping("/list")
    //@GetMapping(path={"/list/{pageNum}","/list"})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum",value = "页码",required = false,paramType = "body"),
            @ApiImplicitParam(name = "pageSize",value = "每页数量",required = false,paramType = "body")
    })
    public ResponseList getInVulList(@RequestBody(required = false) Integer pageNum, @RequestBody(required = false) Integer pageSize){
        InVul inVul = null;
        ResponseList responseList = new ResponseList();
        try {
            int num = 0;
            if(pageNum == null){
                pageNum = 1;
            }
            if(pageSize == null){
                pageSize = 10;
            }
            List<InVul> inVulList = inVulService.getAllActiveInVul(pageNum, pageSize);
            if(inVulList == null){
                responseList.setCode(1001);
                responseList.setMessage("查询数据库异常");
                return responseList;
            }else if(inVulList.isEmpty()){
                responseList.setCode(1006);
                responseList.setMessage("查询结果为空");
                return responseList;
            }
        
            Integer myPageNum = pageNum;
            if(pageNum == null){
                responseList.setCode(1007);
                responseList.setMessage("参数不能为空");
                return responseList;
            }
            num = inVulService.getAllCount();
            responseList.setNum(num);
            Integer start = (myPageNum-1)*pageSize + 1;
            if(start > num){
                if(num%pageSize == 0){
                    myPageNum = num/pageSize;
                }else{
                    myPageNum = num/pageSize + 1;
                }
            }
            responseList.setPageNum(myPageNum);
            start = (myPageNum-1)*pageSize + 1;
            responseList.setStart(start);
            responseList.setEnd((myPageNum-1)*pageSize + inVulList.size());
            List<InVulSample> inVulSampleList = new ArrayList<>();
            Iterator<InVul> iterator = inVulList.iterator();
            SystemInfo systemInfo;
            while(iterator.hasNext()){
                inVul = iterator.next();
                InVulSample inVulSample = new InVulSample();
                inVulSample.setId(inVul.getId());
                systemInfo = systemInfoService.getSystemInfoById(inVul.getSystemId());
                inVulSample.setName(systemInfo.getName());
                inVulSample.setTitle(inVul.getTitle());
                inVulSample.setSerialNum(inVul.getSerialNum());
                inVulSample.setVulType(vulTypeService.getVulTypeById(inVul.getVulType()));
                inVulSample.setRisk(inVul.getRisk());
                inVulSample.setIsNeedFix(inVul.getIsNeedFix());
                inVulSample.setFixStatus(inVul.getFixStatus());
                try {
                    inVulSample.setCreateTime(sdf.format(inVul.getCreateTime()));
                }catch (Exception e){
                    inVulSample.setCreateTime("错误");
                }
                try {
                    if(inVul.getExpectTime() != null){
                        inVulSample.setExpectTime(sdf.format(inVul.getExpectTime()));
                    }else{
                        inVulSample.setExpectTime("-");
                    }
                }catch (Exception e){
                    inVulSample.setExpectTime("错误");
                }
            
                inVulSampleList.add(inVulSample);
            
            }
            responseList.setContent(inVulSampleList);
            responseList.setCode(0);
            responseList.setMessage("成功");
        }catch (Exception e){
            responseList.setCode(1002);
            responseList.setMessage("数据处理失败");
            systemLogService.addSystemLog("内部漏洞","getAllInVulSample",2,"数据处理失败！" + e.toString());
            //logger.error("[InVulController.getAllInVul]发生错误！" + e.toString());
        }
    
        return responseList;
    }
    
    @ApiOperation(value="添加内部漏洞")
    @PostMapping("/add")
    public Response addInVul(@RequestBody InVulInfo inVulInfo){
        Response response = new Response();
        try {
            //System.out.println(inVulInfo.toString());
            InVul inVul = new InVul();
            inVul.setSystemId(inVulInfo.getSystemId());
            inVul.setTitle(Encode.forHtmlAttribute(inVulInfo.getTitle()));
            inVul.setSerialNum(inVul.getSerialNum());
            if(inVulInfo.getVulType() == 0){
                inVul.setVulType(null);
            }else{
                inVul.setVulType(inVulInfo.getVulType());
            }
            inVul.setRisk(inVulInfo.getRisk());
            inVul.setIsNeedFix(inVulInfo.getIsNeedFix());
            inVul.setUrl(inVulInfo.getUrl());
            inVul.setContent(inVulInfo.getContent());
            inVul.setAffect(inVulInfo.getAffect());
            inVul.setVulStatus(inVulInfo.getVulStatus());
            try {
                inVul.setExpectTime(sdf.parse(inVulInfo.getExpectTime()));
            }catch (ParseException e){
                response.setCode(1101);
                response.setMessage("时间错误");
                return response;
            }
            if(inVulInfo.getSecurityUser() == 0){
                inVul.setSecurityUser(null
                );
            }else{
                inVul.setSecurityUser(inVulInfo.getSecurityUser());
            }
            inVul.setSecurityUser(inVul.getSecurityUser());
            int result = inVulService.addInVul(inVul);
            if(result == 1){
                response.setCode(0);
                response.setMessage("OK");
            }else{
                response.setCode(1102);
                response.setMessage("添加失败");
            }
            
        }catch (Exception e){
            response.setCode(1002);
            response.setMessage("数据处理失败");
            systemLogService.addSystemLog("内部漏洞模块","addInVul",2,"数据处理失败！" + e.toString());
        }
        return response;
    }
    
    @ApiOperation(value="删除内部漏洞（设置状态标志）")
    @GetMapping("/del/{id}")
    @ApiImplicitParam(name = "id",value = "需要删除的漏洞ID",required = true,paramType = "path")
    public Response deleteInVulById(@PathVariable(required = true) Long id){
        Response response = new Response();
        try {
            if(id <= 0){
                response.setCode(1103);
                response.setMessage("ID不合法");
                return response;
            }
            int result = inVulService.changeStatusById(id,0);
            if(result == 1){
                response.setCode(0);
                response.setMessage("OK");
            }else{
                response.setCode(1104);
                response.setMessage("未知错误");
            }
        }catch (Exception e){
            response.setCode(1002);
            response.setMessage("数据处理失败");
            systemLogService.addSystemLog("内部漏洞模块","deleteInVulById",2,"数据处理失败！" + e.toString());
        }
        return response;
    }

}
