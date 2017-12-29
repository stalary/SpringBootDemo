package com.stalary.repository;

import com.stalary.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Stalary
 * @description
 * @date 2017/10/21
 */
public interface BookRepository extends JpaRepository<Book,Integer>{

    /**
     * 通过年龄来查询女孩列表
     * @param
     * @return
     */
    List<Book> findByUserId(Integer id);

}
