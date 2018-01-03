package com.stalary.repository;

import com.stalary.domain.User;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Stalary
 * @description
 * @date 26/12/2017
 */
@CacheConfig(cacheNames = "users")
public interface UserRepository extends JpaRepository<User,Integer> {

    /**
     * 通过cookies的ticker来查找用户
     * @param tikcet
     * @return
     */
    @Cacheable
    User findByTicket(String tikcet);

    /**
     * 通过用户名来查找用户
     * @param username
     * @return
     */
    User findByUsername(String username);


}
