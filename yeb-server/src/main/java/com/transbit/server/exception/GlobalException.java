package com.transbit.server.exception;
/**
 * @author lylstart
 * @data 2024/8/24 - 18:45
 * 2024 - 8月 - 周六 - 18 - 45
 */

import com.transbit.server.pojo.RespBean;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

/**
 * @description: 全局异常处理
 * @author jd
 * @date 2024/8/24 18:45
 * @version 1.0
 */
public class GlobalException {

    @ExceptionHandler(SQLException.class)
    public RespBean mysqlException(SQLException e){
        if (e instanceof SQLIntegrityConstraintViolationException){
            return RespBean.error("该数据有关联数据，操作失败!");
        }

        return RespBean.error("数据库异常，操作失败!");
    }
}
