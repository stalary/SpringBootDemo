package com.stalary.repository;

import com.stalary.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Stalary
 * @description
 * @date 2017/10/21
 */
public interface GirlRepository extends JpaRepository<Girl,Integer>{

    /**
     * 通过年龄来查询女孩列表
     * @param age
     * @return
     */
    List<Girl> findByAge(Integer age);

    List<Girl> findByUserId(Integer id);
}
