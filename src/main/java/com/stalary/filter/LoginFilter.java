/**
 * @(#)LoginFilter.java, 2017-12-26.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.filter;

import com.stalary.domain.User;
import com.stalary.interceptor.LoginInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * LoginFilter
 *
 * @author lirongqian
 * @since 26/12/2017
 */
@WebFilter(filterName="loginFilter",urlPatterns="/*")
public class LoginFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        User userSession = (User) request.getSession().getAttribute("user");
        if (userSession != null) {
            request.getSession().setAttribute("user", userSession);
        }
        filterChain.doFilter(req, res);
    }

    @Override
    public void destroy() {

    }
}