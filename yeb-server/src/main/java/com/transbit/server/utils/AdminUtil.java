package com.transbit.server.utils;
/**
 * @author lylstart
 * @data 2024/8/26 - 15:18
 * 2024 - 8月 - 周一 - 15 - 18
 */

import com.transbit.server.pojo.Admin;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @description: 获取当前登录的管理员
 * @author jd
 * @date 2024/8/26 15:18
 * @version 1.0
 */
public class AdminUtil {
    public static Admin getCurrentAdmin() {
       return (Admin) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
