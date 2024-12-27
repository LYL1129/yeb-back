package com.transbit.server.service;

import com.transbit.server.pojo.Employee;
import com.baomidou.mybatisplus.extension.service.IService;
import com.transbit.server.pojo.RespBean;
import com.transbit.server.pojo.RespPageBean;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Gavin
 * @since 2024-08-10
 */
public interface IEmployeeService extends IService<Employee> {

    /**
     * 获取所有员工分页
     * @param currentPage
     * @param size
     * @param beginDateScope
     * @return
     */
    RespPageBean getEmployeeByPage(Integer currentPage, Integer size, Employee employee, LocalDate[] beginDateScope);

    /**
     * 获取最大工号
     * @return
     */
    RespBean maxWorkID();

    /**
     * 添加employee
     * @param employee
     * @return
     */
    RespBean addEmp(Employee employee);

    /**
     * 查询员工
     * @param id
     * @return
     */
    List<Employee> getEmployee(Integer id);
}
