package com.transbit.server.controller;
/**
 * @author lylstart
 * @data 2024/8/18 - 10:56
 * 2024 - 8月 - 周日 - 10 - 56
 */

import com.transbit.server.pojo.Admin;
import com.transbit.server.pojo.AdminLoginParam;
import com.transbit.server.pojo.RespBean;
import com.transbit.server.service.IAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

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

    /**
     * 前端传用户名和密码，单独准备实体类，因为元实体太大
     * 使用Spring Security 自带的 userdetalservice里面的loadUserByUsername
     * 登录成功后返回一个token，登录不成功，重新登录
     * 之后的请求携带token，准备一个token拦截器，验证token是否有效
     * 如果token有效，允许访问其他接口
     * @param adminLoginParam
     * @param request
     * @return
     */
    @ApiOperation(value = "登录之后返回token")
    @PostMapping("/login")
    public RespBean login(@RequestBody AdminLoginParam adminLoginParam, HttpServletRequest request){
        return adminService.login(adminLoginParam.getUsername(),
                adminLoginParam.getPassword(),
                adminLoginParam.getCode(),
                request);
    }

    @ApiOperation(value = "获取当前登录用户的信息")
    @GetMapping("admin/info")
    public Admin getAdminInfo(Principal principal){
        if (null == principal){
            return null;
        }
        String username = principal.getName();
        Admin admin = adminService.getAdminByUserName(username);
        admin.setPassword(null);
//        admin.setRoles(adminService.getRoles(admin.getId()));
        //加上登录角色的权限，之前只有username，password
        admin.setRoles(adminService.getRoles(admin.getId()));
        return admin;
    }

    @ApiOperation(value="退出登录")
    @PostMapping("/logout")
    public RespBean logout(){
        return RespBean.success("注销成功！");
    }

}
