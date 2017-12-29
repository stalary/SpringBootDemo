/**
 * @(#)UserService.java, 2017-12-26.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.service;

import com.stalary.domain.User;
import com.stalary.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * UserService
 *
 * @author lirongqian
 * @since 26/12/2017
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void register(User user) {
        userRepository.save(user);
    }

    public User findByTicket(String ticket) {
        return userRepository.findByTicket(ticket);
    }

    public User findByUserName(String username) {
        return userRepository.findByUsername(username);
    }
}