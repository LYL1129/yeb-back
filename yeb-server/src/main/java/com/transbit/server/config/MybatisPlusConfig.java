package com.transbit.server.config;
/**
 * @author lylstart
 * @data 2024/8/26 - 17:25
 * 2024 - 8月 - 周一 - 17 - 25
 */

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: 分页插件
 * @author jd
 * @date 2024/8/26 17:25
 * @version 1.0
 */
@Configuration
public class MybatisPlusConfig {

    @Bean
    public PaginationInterceptor paginationInterceptor(){
        return new PaginationInterceptor();
    }
}
