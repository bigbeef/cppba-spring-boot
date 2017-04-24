package com.cppba.repository;


import base.dao.BaseRepository;
import com.cppba.entity.User;
import com.cppba.repository.custom.UserRepositoryCustom;

import java.util.List;

/**
 * 开发者
 * nickName:大黄蜂
 * email:245655812@qq.com
 * github:https://github.com/bigbeef
 */
//同时继承base和自定义repository,自定义接口实现命名必须以此接口名加后缀
public interface UserRepository extends BaseRepository<User, Long>, UserRepositoryCustom {

    //spring data jpa 自动生成sql
    List<User> findByUserNameOrPassword(String userName, String password);

}
