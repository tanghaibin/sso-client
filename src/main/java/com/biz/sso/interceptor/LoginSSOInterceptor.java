package com.biz.sso.interceptor;

import com.biz.sso.config.SSOConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截必须登录才能访问的资源
 *
 * @author haibin.tang
 * @create 2018-03-17 12:34
 **/
public class LoginSSOInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private SSOConfig ssoConfig;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(request.getse)
    }
}
