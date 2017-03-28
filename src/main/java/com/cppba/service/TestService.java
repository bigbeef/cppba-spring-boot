package com.cppba.service;

import com.cppba.dao.TestDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TestService {

    @Resource
    private TestDao testDao;

    public void query(){
        testDao.query();
    }
}
