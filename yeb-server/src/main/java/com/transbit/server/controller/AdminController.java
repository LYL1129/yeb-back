package com.transbit.server.controller;


import com.transbit.server.pojo.Admin;
import com.transbit.server.pojo.RespBean;
import com.transbit.server.pojo.Role;
import com.transbit.server.service.IAdminService;
import com.transbit.server.service.IRoleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Gavin
 * @since 2024-08-10
 */
@RestController
@RequestMapping("/system/admin")
public class AdminController {

    @Autowired
    private IAdminService adminService;

    @Autowired
    private IRoleService roleService;

    /**
     * 获取所有操作员
     * @param keywords
     * @return
     */
    @ApiOperation(value="获取所有操作员")
    @PostMapping("/listAll")
    public List<Admin> getAllAdmins(String keywords){
        return adminService.getAllAdmins(keywords);
    }

    @ApiOperation(value="更新操作员")
    @PutMapping("update")
    public RespBean updateAdmin(@RequestBody Admin admin){
        if(adminService.updateById(admin)){
            return RespBean.success("更新成功");
        }
        return RespBean.error("更新失败");
    }

    @ApiOperation(value="删除操作员")
    @DeleteMapping("delete/{id}")
    public RespBean deleteAdmin(@PathVariable Integer id){
        if(adminService.removeById(id)){
            return RespBean.success("删除成功");
        }
        return RespBean.error("删除失败");
    }

    @ApiOperation(value="获取所有角色")
    @PutMapping("/roles")
    public List<Role> getAllRoles(){
        return roleService.list();
    }

    /**
     * 更新操作员角色
     * @param adminId
     * @param rids
     * @return
     */
    @ApiOperation(value="更新操作员角色")
    @PutMapping("/role")
    public RespBean updateAdminRole(Integer adminId, Integer[] rids){
        return adminService.updateAdminRole(adminId, rids);
    }
}
