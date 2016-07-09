package com.cppba.web;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Transactional
public class CommonAction {

    @Resource
    private SessionFactory sessionFactory;

    @RequestMapping("test")
    public void test(){
        Session session = sessionFactory.getCurrentSession();
        SQLQuery sqlQuery = session.createSQLQuery("select * from user");
        List list = sqlQuery.list();
        System.out.printf(list.size()+"");
    }
}
