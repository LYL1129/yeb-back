package com.transbit.server.service.impl;

import com.transbit.server.pojo.Admin;
import com.transbit.server.pojo.Menu;
import com.transbit.server.mapper.MenuMapper;
import com.transbit.server.service.IMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Gavin
 * @since 2024-08-10
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    /**
     * 通过用户id查询菜单列表
     * @return
     */
    @Override
    public List<Menu> getMenuByAdminId() {

        Integer adminId = ((Admin) SecurityContextHolder.getContext().getAuthentication().getPrincipal())
                .getId();

        ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
        //从redis获取数据，
        List<Menu> menus = (List<Menu>)valueOperations.get("menu_" + adminId);
        // 如果为空，查数据库
        if(CollectionUtils.isEmpty(menus)){
            menus = menuMapper.getMenuByAdminId(adminId);
            // 将数据设置到redis
            valueOperations.set("menu_"+adminId, menus);
        }
        return menus;
    }

    /**
     * 根据角色获取菜单列表
     * @return
     */
    @Override
    public List<Menu> getMenusWithRole() {
        return menuMapper.getMenusWithRole();
    }

}
