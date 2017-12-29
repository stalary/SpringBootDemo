/**
 * @(#)LoginController.java, 2017-12-26.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.controller;

import com.stalary.annotation.LoginRequired;
import com.stalary.domain.Result;
import com.stalary.domain.User;
import com.stalary.handle.UserContextHolder;
import com.stalary.service.BookService;
import com.stalary.service.UserService;
import com.stalary.utils.DigestUtil;
import com.stalary.utils.MD5Util;
import com.stalary.utils.ResultUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * LoginController
 *
 * @author lirongqian
 * @since 26/12/2017
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "注册", notes = "只需要传入用户名和密码")
    @PostMapping(value = "/register")
    public Result userRegister(
            @RequestBody User register,
            HttpServletResponse response) {
        String ticket = UUID.randomUUID().toString().replace("-", "");
        Cookie cookie = new Cookie("ticket", DigestUtil.Encrypt(ticket));
        response.addCookie(cookie);
        cookie.setPath("/");
        User newUser = new User();
        newUser.setUsername(register.getUsername());
        String salt = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 5);
        newUser.setPassword(MD5Util.MD5(MD5Util.MD5(register.getPassword()) + salt));
        newUser.setSalt(salt);
        newUser.setTicket(ticket);
        userService.register(newUser);
        return ResultUtil.success(newUser);
    }

    @ApiOperation(value = "获取一个用户", notes = "测试方法")
    @LoginRequired
    @GetMapping(value = "/get")
    public Result getUser() {
        return ResultUtil.success(UserContextHolder.get());
    }

    @ApiOperation(value = "登陆", notes = "只需要传入用户名和密码")
    @PostMapping(value = "/login")
    public Result userLogin(
            @RequestBody User login,
            HttpServletResponse response) {
        User u = userService.findByUserName(login.getUsername());
        if (u == null) {
            return ResultUtil.error(1, "不存在该用户！");
        }
        String ticket = u.getTicket();
        Cookie cookie = new Cookie("ticket", DigestUtil.Encrypt(ticket));
        response.addCookie(cookie);
        cookie.setPath("/");
        if (u.getPassword().equals(MD5Util.MD5(MD5Util.MD5(login.getPassword()) + u.getSalt()))) {
            return ResultUtil.success("登陆成功");
        }
        return ResultUtil.error(2, "密码错误！");
    }

    @ApiOperation(value = "退出")
    @GetMapping(value = "logout")
    public Result userLogout(
            HttpServletResponse response) {
        Cookie cookie = new Cookie("ticket", null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        cookie.setPath("/");
        UserContextHolder.remove();
        return ResultUtil.success("退出成功");
    }

}
