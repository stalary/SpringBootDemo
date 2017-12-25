package com.stalary.controller;

import com.stalary.cassandra.Query;
import com.stalary.cassandra.Student;
import com.stalary.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Stalary
 * @description 测试spring boot
 * @date 2017/10/21
 */
// 相当于ResponseBody+Controller注解
@RestController
@RequestMapping(value = "/hello")
public class HelloController {

    @Autowired
    private GirlProperties girlProperties;

    @Autowired
    private Query query;

    @RequestMapping(value = "/say",method = RequestMethod.GET)
    public String say() {
        return "zyw " + "cupSize is " + girlProperties.getCupSize() +" age is " + girlProperties.getAge();
    }

//    @RequestMapping(value = "/cassandraQuery",method = RequestMethod.GET)
//    public Student query() {
//        return query.getStudentByKeys(1, "jinan", "stalary");
//    }
//
//    @RequestMapping(value = "/cassandraInsert",method = RequestMethod.GET)
//    public void insert() {
//        query.insert();
//    }

}
