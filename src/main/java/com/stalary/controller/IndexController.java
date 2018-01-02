/**
 * @(#)IndexController.java, 2018-01-02.
 * <p>
 * Copyright 2018 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * IndexController
 *
 * @author lirongqian
 * @since 02/01/2018
 */
@Controller
public class IndexController {

    @RequestMapping(value = "/")
    public String helloHtml() {
        return "index";
    }
}