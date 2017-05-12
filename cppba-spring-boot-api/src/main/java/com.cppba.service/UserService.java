package com.cppba.service;


import com.cppba.base.bean.Result;

public interface UserService {

    Result login(String UserName, String password) throws Exception;

    Result getById(Long id);
}
