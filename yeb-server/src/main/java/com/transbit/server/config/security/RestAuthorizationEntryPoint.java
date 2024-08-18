package com.transbit.server.config.security;
/**
 * @author lylstart
 * @data 2024/8/18 - 15:02
 * 2024 - 8月 - 周日 - 15 - 02
 */

import com.fasterxml.jackson.databind.ObjectMapper;
import com.transbit.server.pojo.RespBean;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @description: 当未登陆或者token失效时访问接口自定义返回的结果
 * @author jd
 * @date 2024/8/18 15:02
 * @version 1.0
 */
@Component
public class RestAuthorizationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        PrintWriter writer = response.getWriter();
        RespBean error = RespBean.error("您还没登录，请先登录");
        error.setCode(401);
        writer.write(new ObjectMapper().writeValueAsString(error));
        writer.flush();
        writer.close();
    }
}
