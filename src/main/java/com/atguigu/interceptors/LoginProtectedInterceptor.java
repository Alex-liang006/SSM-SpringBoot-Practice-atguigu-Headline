package com.atguigu.interceptors;

import com.atguigu.utils.JwtHelper;
import com.atguigu.utils.Result;
import com.atguigu.utils.ResultCodeEnum;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.awt.desktop.PreferencesHandler;

/**
 * Classname: LoginProtectedInterceptor
 * Package: com.atguigu.interceptors
 * Description:
 * 登录保护拦截器，当用户对新闻进行增删改时检查用户token，看其是否已登录
 *          检查请求头是否包含有效token
 *              有，放行操作；
 *              无，拦截操作，返回504
 * @Author Alex Liang
 * @Create 2024/6/8 9:55
 * @Version 1.0
 */
@Component
public class LoginProtectedInterceptor implements HandlerInterceptor {
    
    @Autowired
    private JwtHelper jwtHelper;
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 从请求头中获取token
        String token = request.getHeader("token");
        boolean expiration = jwtHelper.isExpiration(token);
        // 检查token是否有效
        if (!expiration) {
            // 有效放行
            return true;
        }
        // 无效返回504状态的json
        Result result = Result.build(null, ResultCodeEnum.NOTLOGIN);
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(result);
        response.getWriter().print(json);
        return false;
    }
}
