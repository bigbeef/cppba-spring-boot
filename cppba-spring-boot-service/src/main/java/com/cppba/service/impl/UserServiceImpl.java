package com.cppba.service.impl;

import com.cppba.base.bean.Result;
import com.cppba.base.bean.UserJwt;
import com.cppba.base.util.JwtUtil;
import com.cppba.base.util.MD5Util;
import com.cppba.base.util.Results;
import com.cppba.entity.User;
import com.cppba.repository.UserRepository;
import com.cppba.service.UserService;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Map;


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
    public Result login(String UserName, String password) throws Exception {
        User user = userRepository.getByUserName(UserName);
        if (user == null) {
            return Results.failure("用户不存在！");
        }
        String Md5Password= MD5Util.encode32Md5(password);
        if (!StringUtils.equals(user.getPassword(), Md5Password)) {
            return Results.failure("密码不正确！");
        }
        UserJwt userJwt = new UserJwt();
        userJwt.setId(user.getId());
        userJwt.setUserName(user.getUserName());
        userJwt.setRoles(new String[]{"login"});
        String token = JwtUtil.createJwt(userJwt);
        Map map = Maps.newHashMap();
        map.put("token",token);
        map.put("user",user);
        return Results.successWithData(map,"登录成功！");
    }

    @Override
    public Result getById(Long id) {
        User user = userRepository.getById(id);
        if(user == null){
            return Results.failure("用户不存在");
        }
        return Results.successWithData(user);
    }

    @Override
    public Result update(Long id, String nickName, String title, String keyword, String description, String remark) {
        User user = userRepository.getOne(id);
        if(user == null){
            return Results.failure("用户不存在");
        }
        user.setNickName(nickName);
        user.setTitle(title);
        user.setKeyword(keyword);
        user.setDescription(description);
        user.setRemark(remark);
        userRepository.save(user);
        return Results.success("修改成功");
    }
}
