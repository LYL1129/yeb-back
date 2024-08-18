package com.transbit.server.controller;
/**
 * @author lylstart
 * @data 2024/8/18 - 15:25
 * 2024 - 8月 - 周日 - 15 - 25
 */

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: TODO
 * @author jd
 * @date 2024/8/18 15:25
 * @version 1.0
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

}
