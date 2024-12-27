package com.transbit.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.transbit.server.pojo.MenuRole;
import com.transbit.server.mapper.MenuRoleMapper;
import com.transbit.server.pojo.RespBean;
import com.transbit.server.service.IMenuRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Gavin
 * @since 2024-08-10
 */
@Service
public class MenuRoleServiceImpl extends ServiceImpl<MenuRoleMapper, MenuRole> implements IMenuRoleService {

    @Autowired
    private MenuRoleMapper menuRoleMapper;

    /**
     * 更新角色菜单
     * @param rid
     * @param mids
     * @return
     */
    @Override
    //事务的注解
    @Transactional
    public RespBean updateMenuRole(Integer rid, Integer[] mids) {
        QueryWrapper<MenuRole> queryWrapper = new QueryWrapper<>();
        menuRoleMapper.delete(queryWrapper.eq("rid", rid));

        if(null==mids||0==mids.length){
            return RespBean.success("更新成功！");
        }
        Integer items = menuRoleMapper.insertRecord(rid, mids);
        if(items== mids.length){
            return RespBean.success("更新成功");
        }
        return RespBean.error("更新失败");
    }
}
