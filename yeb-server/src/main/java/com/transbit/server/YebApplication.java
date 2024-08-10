package com.transbit.server;
/**
 * @author lylstart
 * @data 2024/8/10 - 11:53
 * 2024 - 8月 - 周六 - 11 - 53
 */

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @description: TODO
 * @author jd
 * @date 2024/8/10 11:53
 * @version 1.0
 */
@SpringBootApplication
@MapperScan("com.transbit.server.mapper")
public class YebApplication {

    public static void main(String[] args){
        SpringApplication.run(YebApplication.class, args);
    }
}
