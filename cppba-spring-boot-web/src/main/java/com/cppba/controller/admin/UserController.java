package com.cppba.controller.admin;

import com.cppba.base.annotation.RequiresRoles;
import com.cppba.base.bean.CurrentUser;
import com.cppba.base.bean.Result;
import com.cppba.base.util.Results;
import com.cppba.controller.base.BaseController;
import com.cppba.form.admin.SettingForm;
import com.cppba.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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


    @ResponseBody
    @RequestMapping("/login")
    public Result login(String userName, String password) {
        try {
            return userService.login(userName,password);
        } catch (Exception e) {
            e.printStackTrace();
            return Results.failure("请检查输入密码！");
        }
    }


    @ResponseBody
    @RequiresRoles({"login"})
    @RequestMapping("/setting")
    public Result setting(HttpServletRequest request) {
        CurrentUser currentUser = getCurrentUser(request);
        return userService.setting(currentUser.getId());
    }


    @ResponseBody
    @RequiresRoles({"login"})
    @RequestMapping(value="/setting/update",method = RequestMethod.POST)
    public Result settingUpdate(HttpServletRequest request, SettingForm settingFrom) {
        CurrentUser currentUser = getCurrentUser(request);
        return userService.settingUpdate(currentUser.getId(),settingFrom);
    }
}
