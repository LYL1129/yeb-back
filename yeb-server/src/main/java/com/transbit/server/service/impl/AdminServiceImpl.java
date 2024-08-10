package com.transbit.server.service.impl;

import com.transbit.server.pojo.Admin;
import com.transbit.server.mapper.AdminMapper;
import com.transbit.server.service.IAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Gavin
 * @since 2024-08-10
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {

}
