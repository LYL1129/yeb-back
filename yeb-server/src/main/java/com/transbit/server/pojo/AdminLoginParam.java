package com.transbit.server.pojo;
/**
 * @author lylstart
 * @data 2024/8/18 - 10:42
 * 2024 - 8月 - 周日 - 10 - 42
 */

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @description: 用户登录实体类
 * @author jd
 * @date 2024/8/18 10:42
 * @version 1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "AdminLogin对象", description = "前端发送的登录对象")
public class AdminLoginParam {

    @ApiModelProperty(value = "用户名",required = true)
    private String username;

    @ApiModelProperty(value = "密码", required = true)
    private String password;
}
