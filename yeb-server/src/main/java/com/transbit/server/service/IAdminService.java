package com.transbit.server.service;

import com.transbit.server.pojo.Admin;
import com.baomidou.mybatisplus.extension.service.IService;
import com.transbit.server.pojo.RespBean;
import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Gavin
 * @since 2024-08-10
 */
public interface IAdminService extends IService<Admin> {

    RespBean login(String username, String password, String code, HttpServletRequest request);

    /**
     * 根据用户名获取用户
     * @param username
     * @return
     */
    public Admin getAdminByUserName(String username);
}
