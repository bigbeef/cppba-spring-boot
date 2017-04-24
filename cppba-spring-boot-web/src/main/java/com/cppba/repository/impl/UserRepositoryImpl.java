package com.cppba.repository.impl;


import com.cppba.entity.User;
import com.cppba.repository.custom.UserRepositoryCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * 开发者
 * nickName:大黄蜂
 * email:245655812@qq.com
 * github:https://github.com/bigbeef
 */
//用户自定义repository实现（命名必须以最顶层repository加后缀(默认Impl)规则，这里是UserRepository+Impl）
@Repository
public class UserRepositoryImpl implements UserRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<User> findByUserNameAndPassword(String userName,String password) {
        Query query = em.createQuery("from User where userName = :userName and password = :password");
        query.setParameter("userName",userName);
        query.setParameter("password",password);
        return query.getResultList();
    }
}
