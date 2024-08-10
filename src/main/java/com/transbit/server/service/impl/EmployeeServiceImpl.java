package com.transbit.server.service.impl;

import com.transbit.server.pojo.Employee;
import com.transbit.server.mapper.EmployeeMapper;
import com.transbit.server.service.IEmployeeService;
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
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements IEmployeeService {

}
