/**
 * @(#)BookService.java, 2017-12-28.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.service;

import com.stalary.domain.Book;
import com.stalary.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * BookService
 *
 * @author lirongqian
 * @since 28/12/2017
 */
@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public void deleteBook(Integer id) {
        bookRepository.delete(id);
    }

    public void addBook(Book book) {
        bookRepository.save(book);
    }

    public List<Book> findByUserId(Integer id) {
        return bookRepository.findByUserId(id);
    }
}