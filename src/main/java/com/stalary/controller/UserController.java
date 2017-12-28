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
import com.stalary.service.UserService;
import com.stalary.utils.DigestUtil;
import com.stalary.utils.MD5Utils;
import com.stalary.utils.ResultUtil;
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
        newUser.setPassword(MD5Utils.MD5(MD5Utils.MD5(register.getPassword()) + salt));
        newUser.setSalt(salt);
        newUser.setTicket(ticket);
        userService.register(newUser);
        return ResultUtil.success(newUser);
    }

    @LoginRequired
    @GetMapping(value = "/get")
    public Result getUser() {
        return ResultUtil.success(UserContextHolder.get());
    }

    @GetMapping(value = "/login")
    public Result userLogin(
            @RequestParam String username,
            @RequestParam String password,
            HttpServletResponse response) {
        User u = userService.findByUserName(username);
        if (u == null) {
            return ResultUtil.error(1, "不存在该用户！");
        }
        String ticket = u.getTicket();
        Cookie cookie = new Cookie("ticket", DigestUtil.Encrypt(ticket));
        response.addCookie(cookie);
        cookie.setPath("/");
        if (u.getPassword().equals(MD5Utils.MD5(MD5Utils.MD5(password) + u.getSalt()))) {
            return ResultUtil.success("登陆成功");
        }
        return ResultUtil.error(2, "密码错误！");
    }

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
