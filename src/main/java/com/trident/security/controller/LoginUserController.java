/**
 * Created by IntelliJ IDEA.
 * User: trident
 * Date: 2022/6/4
 * Time: 13:22
 **/
package com.trident.security.controller;

import com.trident.security.bean.LoginUser;
import com.trident.security.bean.SystemLog;
import com.trident.security.service.LoginUserService;
import com.trident.security.service.SystemLogService;
import com.trident.security.utils.loginUser.LoginUserSample;
import com.trident.security.utils.response.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Api(tags = "用户")
@RestController
@RequestMapping("api/user")
public class LoginUserController {
    @Resource
    private LoginUserService loginUserService;
    @Resource
    private SystemLogService systemLogService;
    
    @ApiOperation(value="依据用户类型和状态获取用户清单")
    @GetMapping("/list")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userType",value = "用户类型",required = false,paramType = "body"),
            @ApiImplicitParam(name = "status",value = "状态",required = false,paramType = "body")
    })
    public Response getUserByUserTypeAndStatus(@RequestBody(required = false) Integer userType, @RequestBody(required = false) Integer status){
        Response response = new Response();
        try {
            List<LoginUser> loginUserList = loginUserService.getUserByUserTypeAndStatus(userType,status);
            if(loginUserList.isEmpty()){
                response.setCode(1401);
                response.setMessage("结果为空");
                return response;
            }
            response.setCode(0);
            response.setMessage("OK");
            response.setContent(loginUserList);
        }catch (Exception e){
            response.setCode(1002);
            response.setMessage("数据处理失败");
            systemLogService.addSystemLog("用户模块","getUserByUserTypeAndStatus",2,"数据处理失败！" + e.toString());
            //e.printStackTrace();
        }
        return  response;
    }
    
    @ApiOperation(value="获取可用的安全人员清单")
    @GetMapping("/list/active-security-user")
    public Response getActiveSecurityUser(){
        Response response = getUserByUserTypeAndStatus(1,1);
        if(response.getCode() != 0){
            return response;
        }else{
            
            List<LoginUser> loginUserList = (List<LoginUser>)response.getContent();
            Iterator<LoginUser> iterator = loginUserList.iterator();
            List<LoginUserSample> loginUserSampleList = new ArrayList<>();
            LoginUser loginUser = null;
            while (iterator.hasNext()){
                loginUser = iterator.next();
                LoginUserSample loginUserSample = new LoginUserSample();
                loginUserSample.setId(loginUser.getId());
                loginUserSample.setUsername(loginUser.getUsername());
                loginUserSample.setRealName(loginUser.getRealName());
                loginUserSampleList.add(loginUserSample);
            }
            response.setContent(loginUserSampleList);
        }
        return response;
    }

}
