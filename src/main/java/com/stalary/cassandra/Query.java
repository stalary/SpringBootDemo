/**
 * @(#)Querybuilder.java, 2017-11-15.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.cassandra;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.querybuilder.BuiltStatement;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Iterator;


/**
 * Query
 *
 * @author lirongqian
 * @since 2017/11/15
 */
@Component
public class Query {

//    private Cluster cluster = Cluster.builder()
//            .addContactPoint("127.0.0.1")
//            .build();
//    private Session session = cluster.connect();
//    public void insert() {
//
//        // 创建用户会话
//        Student student = new Student(1, "jinan", "stalary", 20, 140);
//        String cql = "insert into test.student(id,address,name,age,height) values("
//                + student.getId() + ",'" + student.getAddress() + "','" + student.getName()
//                + "'," + student.getAge() + "," + student.getHeight() + ");";
//        System.out.println(cql);
//        session.execute(cql);
//    }
//
//    public Student getStudentByKeys(int id, String address, String name) {
//        Student student = null;
//        ResultSet rs = session.execute(
//                QueryBuilder.select("id", "address", "name", "age", "height")
//                        .from("test", "student")
//                        .where(QueryBuilder.eq("id", id))
//                        .and(QueryBuilder.eq("address", address))
//                        .and(QueryBuilder.eq("name", name)));
//        Iterator<Row> rsIterator = rs.iterator();
//        if (rsIterator.hasNext())
//        {
//            Row row = rsIterator.next();
//            student = new Student();
//            student.setAddress(row.getString("address"));
//            student.setAge(row.getInt("age"));
//            student.setHeight(row.getInt("height"));
//            student.setId(row.getInt("id"));
//            student.setName(row.getString("name"));
//        }
//        return student;
//    }
}