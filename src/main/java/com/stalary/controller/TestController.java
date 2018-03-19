/**
 * @(#)TestController.java, 2018-02-28.
 * <p>
 * Copyright 2018 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.controller;

import com.stalary.domain.Result;
import com.stalary.properties.Props;
import com.stalary.utils.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * TestController
 *
 * @author lirongqian
 * @since 2018/02/28
 */
@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {

    @Autowired
    private Props props;

    @GetMapping("/ip")
    public Result getIp(
            HttpServletRequest request) {
        log.info("key: " + props.getMap());
        log.info("test: " + props.getTest());
        return ResultUtil.success("访问来自：" + request.getLocalAddr() + ":" + request.getLocalPort());
    }
}