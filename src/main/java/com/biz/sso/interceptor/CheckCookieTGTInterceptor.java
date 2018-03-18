package com.biz.sso.interceptor;

import com.biz.sso.config.SSOConfig;
import com.biz.sso.constant.Constant;
import com.biz.sso.support.RedisSupport;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 校验对比Cookie中的票据是否与服务器的一致
 *
 * @author haibin.tang
 * @create 2018-03-17 12:43
 **/
public class CheckCookieTGTInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private RedisSupport redisSupport;

    @Autowired
    private SSOConfig ssoConfig;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Cookie ticket = WebUtils.getCookie(request, Constant.TGT_COOKIE_NAME);
        if(ticket == null) {
            return true;
        }
        if(StringUtils.isNotBlank(redisSupport.get(ticket.getValue()))) {
            return true;
        }
        Cookie cookie = new Cookie(Constant.TGT_COOKIE_NAME, null);
        cookie.setDomain(ssoConfig.getCookieDomain());
        cookie.setPath(ssoConfig.getCookiePath());
        response.addCookie(cookie);
        response.sendRedirect(ssoConfig.getLoginUrl() + "?" + Constant.SSO_REDIRECT_KEY + "=" + request.getRequestURL());
        return false;
    }
}
