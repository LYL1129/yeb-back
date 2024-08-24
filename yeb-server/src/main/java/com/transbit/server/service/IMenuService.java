package com.transbit.server.service;

import com.transbit.server.pojo.Menu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Gavin
 * @since 2024-08-10
 */
public interface IMenuService extends IService<Menu> {
    /**
     * 通过用户id查询菜单列表
     * @return
     */
    public List<Menu> getMenuByAdminId();
}
