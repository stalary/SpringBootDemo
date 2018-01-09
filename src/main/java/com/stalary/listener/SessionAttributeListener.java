/**
 * @(#)SessionAttritubeListener.java, 2017-12-26.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.listener;

import com.stalary.domain.User;
import com.stalary.handle.UserContextHolder;
import com.stalary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * SessionAttritubeListener
 *
 * @author lirongqian
 * @since 26/12/2017
 */
@WebListener
public class SessionAttributeListener implements HttpSessionAttributeListener {

    @Autowired
    private UserService userService;

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        if ("user".equals(event.getName())) {
            User user = userService.findByTicket((String) event.getValue());
            UserContextHolder.set(user);
        }
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        if ("user".equals(event.getName())) {
            UserContextHolder.remove();
        }
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        if ("user".equals(event.getName())) {
            User user = userService.findByTicket((String) event.getValue());
            UserContextHolder.set(user);
        }
    }
}