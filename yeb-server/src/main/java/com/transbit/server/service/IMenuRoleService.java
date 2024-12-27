package com.transbit.server.service;

import com.transbit.server.pojo.MenuRole;
import com.baomidou.mybatisplus.extension.service.IService;
import com.transbit.server.pojo.RespBean;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Gavin
 * @since 2024-08-10
 */
public interface IMenuRoleService extends IService<MenuRole> {

    /**
     * 更新角色菜单
     * @param rid
     * @param mids
     * @return
     */
    public RespBean updateMenuRole(Integer rid, Integer[] mids);
}
