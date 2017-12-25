/**
 * @(#)TeacherResearchController.java, 2017-11-16.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.controller;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * TeacherResearchController
 * 总共6个接口为前台提供
 *
 * @author lirongqian
 * @since 2017/11/16
 */
@RestController
@RequestMapping(value = "/research")
public class TeacherResearchController {

    /**
     * 展示作业的list，是否展示所有作业待定
     */
    //todo：是否展示所有作业
    @GetMapping(value = "/list")
    public void list(
            @RequestParam(required = false) String type,
            @RequestParam(required = false) int id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false, defaultValue = "1") int pageNumber,
            @RequestParam(required = false, defaultValue = "10") int pageSize
    ) {

    }

    /**
     * 查看明细，传入作业ID
     */
    @GetMapping(value = "/detail")
    public void detail(
            @RequestParam int id,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) int detailId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false, defaultValue = "1") int pageNumber,
            @RequestParam(required = false, defaultValue = "10") int pageSize
    ) {

    }

    /**
     * 批阅所有未批改的作业，传入作业ID
     */
    @PostMapping(value = "/readAll")
    public void readAll(
            @RequestParam int id
    ) {

    }

    /**
     * 进入批改，传入明细ID，如果作业类型为习题时，需要传入批改范围
     */
    @GetMapping(value = "/goCorrect")
    public void goCorrect(
            HttpServletRequest request,
            @RequestParam int detailId,
            @RequestParam String type,
            @RequestParam(required = false) int start,
            @RequestParam(required = false) int end,
            @RequestParam(required = false, defaultValue = "0") int index
    ) {

    }

    /**
     * 批改，和重新批改共用一个接口，需要传入作业明细ID，如果传入作业ID，则默认批改队列中的第一个
     */
    @PostMapping(value = "/correct")
    public void correct(
            HttpServletRequest request
    ) {

    }

    /**
     * 保存批改
     */
    @PostMapping(value = "/save")
    public void save(
            HttpServletRequest request
    ) {

    }
}
