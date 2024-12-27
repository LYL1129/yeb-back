package com.transbit.server.config.filter;
/**
 * @author lylstart
 * @data 2024/8/24 - 17:16
 * 2024 - 8月 - 周六 - 17 - 16
 */

import com.transbit.server.pojo.Menu;
import com.transbit.server.pojo.Role;
import com.transbit.server.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

/**
 * @description: TODO
 * @author jd
 * @date 2024/8/24 17:16
 * @version 1.0
 */
@Component
public class CustomFilter implements FilterInvocationSecurityMetadataSource {

    @Autowired
    private IMenuService menuService;

    AntPathMatcher antPathMatcher = new AntPathMatcher();
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        //获取请求url
        String requestUrl = ((FilterInvocation) object).getRequestUrl();
        List<Menu> menus = menuService.getMenusWithRole();
        for(Menu menu : menus){
            //判断请求yrl与菜单角色是否匹配
            if(antPathMatcher.match(menu.getUrl(), requestUrl)){
                String[] toArray = menu.getRoles().stream().map(Role::getName).toArray(String[]::new);
                //匹配的角色全部放在list中
                return SecurityConfig.createList(toArray);
            }
        }
        //未匹配的url默认登录权限
        return SecurityConfig.createList("ROLE_LOGIN");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }
}
