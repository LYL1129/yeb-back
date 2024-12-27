package com.transbit.server.mapper;

import com.transbit.server.pojo.Department;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Gavin
 * @since 2024-08-10
 */
public interface DepartmentMapper extends BaseMapper<Department> {

    /**
     * 获取所有部门
     * @return
     */
    List<Department> getAllDepartments(Integer parentId);

    /**
     * 添加部门
     * @param department
     * @return
     */
    void addDep(Department department);

    /**
     * 删除部门
     * @param department
     */
    void deleteDep(Department department);
}
