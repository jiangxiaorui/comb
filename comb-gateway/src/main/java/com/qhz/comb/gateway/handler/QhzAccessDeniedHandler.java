package com.qhz.comb.gateway.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author jiangting
 * @since 1.0, 2018/5/31
 */
@Slf4j
@Component
public class QhzAccessDeniedHandler extends OAuth2AccessDeniedHandler {

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * 授权拒绝处理，使用R包装
     *
     * @param request       request
     * @param response      response
     * @param authException authException
     * @throws IOException      IOException
     * @throws ServletException ServletException
     */
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException authException) throws IOException, ServletException {
        log.info("授权失败，禁止访问 {}", request.getRequestURI());
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
//        R<String> result = new R<>(new PigDeniedException("授权失败，禁止访问"));
//        response.setStatus(HttpStatus.SC_FORBIDDEN);
//        PrintWriter printWriter = response.getWriter();
//        printWriter.append(objectMapper.writeValueAsString(result));
    }
}
