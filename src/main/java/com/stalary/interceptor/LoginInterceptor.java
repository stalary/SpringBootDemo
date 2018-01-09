/**
 * @(#)LoginInterceptor.java, 2017-12-26.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.interceptor;

import com.stalary.annotation.LoginRequired;
import com.stalary.domain.User;
import com.stalary.enums.ResultEnum;
import com.stalary.exception.MyException;
import com.stalary.handle.UserContextHolder;
import com.stalary.service.UserService;
import com.stalary.utils.DigestUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * LoginInterceptor
 *
 * @author lirongqian
 * @since 26/12/2017
 */
@Slf4j
public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        if (request.getRequestURI().contains("swagger")) {
            return true;
        }
        // 退出时删除session
        if (request.getRequestURI().contains("logout")) {
            request.getSession().removeAttribute("user");
            return true;
        }
        UserContextHolder.set((User) request.getSession().getAttribute("user"));
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        Method method = ((HandlerMethod) handler).getMethod();
        boolean isLoginRequired = isAnnotationPresent(method, LoginRequired.class);
        if (isLoginRequired) {
            if (request.getSession().getAttribute("user") == null) {
                UserContextHolder.remove();
                throw new MyException(ResultEnum.NEED_LOGIN);
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    private boolean isAnnotationPresent(Method method, Class<? extends Annotation> annotationClass) {
        return method.getDeclaringClass().isAnnotationPresent(annotationClass) || method.isAnnotationPresent(annotationClass);
    }
}