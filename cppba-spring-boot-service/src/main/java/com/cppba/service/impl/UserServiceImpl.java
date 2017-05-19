package com.cppba.service.impl;

import com.cppba.base.bean.CurrentUser;
import com.cppba.base.bean.Result;
import com.cppba.base.util.JwtUtil;
import com.cppba.base.util.MD5Util;
import com.cppba.base.util.Results;
import com.cppba.entity.User;
import com.cppba.form.admin.SettingForm;
import com.cppba.repository.UserRepository;
import com.cppba.service.UserService;
import com.cppba.vo.admin.SettingVO;
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
        CurrentUser currentUser = new CurrentUser();
        currentUser.setId(user.getId());
        currentUser.setUserName(user.getUserName());
        currentUser.setRoles(new String[]{"login"});
        String token = JwtUtil.createJwt(currentUser);
        Map map = Maps.newHashMap();
        map.put("token",token);
        map.put("user",user);
        return Results.successWithData(map,"登录成功！");
    }

    @Override
    public Result setting(Long id) {
        User user = userRepository.getById(id);
        if(user == null){
            return Results.failure("用户不存在");
        }
        SettingVO settingVO = new SettingVO(user.getNickName(),user.getRemark(),user.getTitle(),user.getKeyword(),user.getDescription());
        return Results.successWithData(settingVO);
    }

    @Override
    public Result settingUpdate(Long id, SettingForm settingFrom) {
        User user = userRepository.getById(id);
        if(user == null){
            return Results.failure("用户不存在");
        }
        user.setNickName(settingFrom.getNickName());
        user.setTitle(settingFrom.getTitle());
        user.setKeyword(settingFrom.getKeyword());
        user.setDescription(settingFrom.getDescription());
        user.setRemark(settingFrom.getRemark());
        userRepository.save(user);
        return Results.success("修改成功");
    }
}
