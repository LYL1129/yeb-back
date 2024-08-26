package com.transbit.server.mapper;

import com.transbit.server.pojo.MenuRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Gavin
 * @since 2024-08-10
 */
public interface MenuRoleMapper extends BaseMapper<MenuRole> {

    /**
     * 更新角色菜单
     * @param rid
     * @param mids
     * @return
     */
    public Integer insertRecord(@Param("rid") Integer rid, @Param("mids") Integer[] mids);
}
