package com.transbit.server.pojo;
/**
 * @author lylstart
 * @data 2024/8/26 - 17:27
 * 2024 - 8月 - 周一 - 17 - 27
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @description: 分页公共返回对象
 * @author jd
 * @date 2024/8/26 17:27
 * @version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RespPageBean {
    /**
     * 总条数
     */
    private Long total;
    /**
     * 数据list
     */
    private List<?> data;
}
