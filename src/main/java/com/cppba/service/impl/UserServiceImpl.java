package com.cppba.service.impl;

import com.cppba.entity.User;
import com.cppba.repository.UserRepository;
import com.cppba.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * 开发者
 * nickName:大黄蜂
 * email:245655812@qq.com
 * github:https://github.com/bigbeef
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;

    @Override
    public User get(Long id) {
        Sort.Order order1 = new Sort.Order(Sort.Direction.DESC,"u.id");
        Sort.Order order2 = new Sort.Order(Sort.Direction.DESC,"u.userName");
        Sort sort = new Sort(order1,order2);
        Page page = userRepository.pageByHql("from User u",null,1,1,sort);

        return userRepository.getOne(id);
    }
}
