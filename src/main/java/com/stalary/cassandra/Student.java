/**
 * @(#)Student.java, 2017-11-15.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.cassandra;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Student
 *
 * @author lirongqian
 * @since 2017/11/15
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    int id;
    String address;
    String name;
    int age;
    int height;
}