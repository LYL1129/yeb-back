package com.transbit.server.controller;
/**
 * @author lylstart
 * @data 2024/8/18 - 10:56
 * 2024 - 8月 - 周日 - 10 - 56
 */

import com.transbit.server.pojo.AdminLoginParam;
import com.transbit.server.pojo.RespBean;
import com.transbit.server.service.IAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: TODO
 * @author jd
 * @date 2024/8/18 10:56
 * @version 1.0
 */
@Api(tags = "LoginController")
@RestController
public class LoginController {

    @Autowired
    private IAdminService adminService;

    @ApiOperation(value = "登录之后返回token")
    @RequestMapping("/login")
    public RespBean login(AdminLoginParam adminLoginParam, HttpServletRequest request){
        return adminService.login(adminLoginParam.getUsername(), adminLoginParam.getPassword(),request);
    }
}
