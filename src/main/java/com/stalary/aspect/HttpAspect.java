package com.stalary.aspect;

import com.stalary.domain.User;
import com.stalary.handle.UserContextHolder;
import com.stalary.service.UserService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSessionAttributeListener;


/**
 * @author Stalary
 * @description
 * @date 2017/10/22
 */
@Aspect
@Component
public class HttpAspect {

    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    @Autowired
    private UserService userService;

    @Pointcut("execution(* com.stalary.controller.*.*(..))")
    public void log() {
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        logger.info("URI: " + request.getRequestURI());
    }

    @After("log()")
    public void doAfter() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        if (request.getRequestURI().contains("register") || request.getRequestURI().contains("login")) {
            Cookie[] cookies = request.getCookies();
            for (Cookie cookie : cookies) {
                if ("ticket".equals(cookie.getName())) {
                    String value = cookie.getValue();
                    User login = userService.findByTicket(value);
                    request.getSession().setAttribute("user", login);
                    logger.info("user: " + login);
                }
            }
        }
        if (request.getRequestURI().contains("logout")) {
            request.getSession().removeAttribute("user");
        }
    }

    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterReturning(Object object) {
        logger.info("response={}", object.toString());
    }

}
