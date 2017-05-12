package com.cppba.controller.admin;

import com.cppba.base.annotation.RequiresRoles;
import com.cppba.base.bean.Result;
import com.cppba.base.bean.UserJwt;
import com.cppba.base.util.Results;
import com.cppba.controller.base.BaseController;
import com.cppba.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 开发者
 * nickName:大黄蜂
 * email:245655812@qq.com
 * github:https://github.com/bigbeef
 */
@RestController
@RequestMapping("/admin/user")
public class UserController extends BaseController {

    @Resource
    private UserService userService;

    @RequestMapping("/login")
    @ResponseBody
    public Result login(String userName, String password) {
        try {
            return userService.login(userName,password);
        } catch (Exception e) {
            e.printStackTrace();
            return Results.failure("请检查输入密码！");
        }
    }

    @RequestMapping("/get")
    @ResponseBody
    @RequiresRoles({"admin"})
    public Result get(HttpServletRequest request) {
        UserJwt userJwt = getCurrentUser(request);
        return userService.getById(userJwt.getId());
    }
}
