package com.transbit.server.service.impl;

import com.transbit.server.pojo.Oplog;
import com.transbit.server.mapper.OplogMapper;
import com.transbit.server.service.IOplogService;
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
public class OplogServiceImpl extends ServiceImpl<OplogMapper, Oplog> implements IOplogService {

}
