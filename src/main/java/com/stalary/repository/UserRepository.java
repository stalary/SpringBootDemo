package com.stalary.repository;

import com.stalary.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Stalary
 * @description
 * @date 26/12/2017
 */
public interface UserRepository extends JpaRepository<User,Integer> {

    /**
     * 通过cookies的ticker来查找用户
     * @param tikcet
     * @return
     */
    User findByTicket(String tikcet);

    /**
     * 通过用户名来查找用户
     * @param username
     * @return
     */
    User findByUsername(String username);


}
