/**
 * @(#)InterceptorConfig.java, 2017-12-28.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * InterceptorConfig
 *
 * @author lirongqian
 * @since 28/12/2017
 */
@Configuration
@EnableWebMvc
public class InterceptorConfig extends WebMvcConfigurerAdapter {

    @Bean
    LoginInterceptor localInterceptor() {
        return new LoginInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localInterceptor())
                .excludePathPatterns("/register**")
                .excludePathPatterns("/login**")
                .addPathPatterns("/**");
    }
}