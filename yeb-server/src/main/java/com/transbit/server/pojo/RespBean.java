package com.transbit.server.pojo;
/**
 * @author lylstart
 * @data 2024/8/18 - 10:48
 * 2024 - 8月 - 周日 - 10 - 48
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: TODO
 * @author jd
 * @date 2024/8/18 10:48
 * @version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RespBean {
    private long code;
    private String message;
    private Object obj;


    /**
     成功返回结果
     @param message
     @return
     */
    public static RespBean success(String message){
        return new RespBean(200, message, null);
    }

    /**
     * 成功返回结果
     * @param message
     * @param obj
     * @return
     */
    public static RespBean success(String message, Object obj){
        return new RespBean(200, message, obj);
    }

    /**
     * 失败返回对象
     * @param message
     * @return
     */
    public static RespBean error(String message) {
        return new RespBean(500, message, null);
    }

    public static RespBean error(String message, Object obj){
        return new RespBean(500, message, obj);
    }
}
