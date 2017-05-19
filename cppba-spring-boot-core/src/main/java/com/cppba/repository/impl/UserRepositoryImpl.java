package com.cppba.repository.impl;


import com.cppba.base.dao.impl.BaseRepositoryImpl;
import com.cppba.entity.User;
import com.cppba.repository.custom.UserRepositoryCustom;
import org.springframework.stereotype.Repository;

/**
 * 开发者
 * nickName:大黄蜂
 * email:245655812@qq.com
 * github:https://github.com/bigbeef
 */
//用户自定义repository实现（命名必须以最顶层repository加后缀(默认Impl)规则，这里是UserRepository+Impl）
@Repository
public class UserRepositoryImpl extends BaseRepositoryImpl<User,Long> implements UserRepositoryCustom {

}
