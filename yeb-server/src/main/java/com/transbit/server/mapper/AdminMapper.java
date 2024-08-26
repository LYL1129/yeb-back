package com.transbit.server.mapper;

import com.transbit.server.pojo.Admin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.transbit.server.pojo.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Gavin
 * @since 2024-08-10
 */
public interface AdminMapper extends BaseMapper<Admin> {


    /**
     * 获取所有操作员
     * @param id
     * @param keywords
     * @return
     */
    List<Admin> getAllAdmins(@Param("id") Integer id, @Param("keywords") String keywords);
}
