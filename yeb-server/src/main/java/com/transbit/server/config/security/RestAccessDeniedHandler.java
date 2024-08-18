package com.transbit.server.config.security;
/**
 * @author lylstart
 * @data 2024/8/18 - 15:05
 * 2024 - 8月 - 周日 - 15 - 05
 */

import com.fasterxml.jackson.databind.ObjectMapper;
import com.transbit.server.pojo.RespBean;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @description: TODO
 * @author jd
 * @date 2024/8/18 15:05
 * @version 1.0
 */
@Component
public class RestAccessDeniedHandler implements AccessDeniedHandler {

    public void handle(HttpServletRequest request,
                       HttpServletResponse response,
                       AccessDeniedException accessDeniedException) throws IOException, ServletException {
        response.setCharacterEncoding("UTF8");
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        RespBean error = RespBean.error("权限不足，请联系管理员！");
        error.setCode(403);
        out.write(new ObjectMapper().writeValueAsString(error));
        out.flush();
        out.close();
    }
}
