package com.stalary.repository;

import com.stalary.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Stalary
 * @description
 * @date 03/01/2018
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    UserService userService;

    @Test
    public void findByTicket() {
        log.info("第一次");
        userService.findByTicket("d9740838740b444495521c40969921b0");
        log.info("第二次");
        userService.findByTicket("d9740838740b444495521c40969921b0");
    }
}