/**
 * @(#)BookController.java, 2017-12-28.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.controller;

import com.stalary.annotation.LoginRequired;
import com.stalary.domain.Book;
import com.stalary.domain.Result;
import com.stalary.handle.UserContextHolder;
import com.stalary.service.BookService;
import com.stalary.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * BookController
 *
 * @author lirongqian
 * @since 28/12/2017
 */
@RestController
@RequestMapping(value = "/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @ApiOperation(value = "添加", notes = "仅需要传入title和author")
    @PostMapping(value = "add")
    @LoginRequired
    public Result addBook(
            @RequestBody Book book) {
        Integer userId = UserContextHolder.get().getId();
        Book newBook = new Book();
        newBook.setTitle(book.getTitle());
        newBook.setUserId(userId);
        newBook.setAuthor(book.getAuthor());
        bookService.addBook(newBook);
        return ResultUtil.success();
    }

    @ApiOperation(value = "删除", notes = "传入图书的id")
    @GetMapping(value = "delete")
    @LoginRequired
    public Result deleteBook(
            @RequestParam Integer id) {
        bookService.deleteBook(id);
        return ResultUtil.success();
    }

    @ApiOperation(value = "查找", notes = "查找当前用户的图书，返回列表")
    @LoginRequired
    @GetMapping(value = "getList")
    public Result getBookList() {
        Integer userId = UserContextHolder.get().getId();
        return ResultUtil.success(bookService.findByUserId(userId));
    }

}