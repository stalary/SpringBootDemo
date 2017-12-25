package com.stalary.repository;

import com.stalary.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Stalary
 * @description
 * @date 26/12/2017
 */
public interface UserRepository extends JpaRepository<User,Integer> {

    User findByTicket(String tikcet);

    User findByUsername(String username);
}
