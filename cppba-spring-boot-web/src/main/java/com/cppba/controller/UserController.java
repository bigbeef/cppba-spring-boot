package com.cppba.controller;

import com.cppba.base.bean.JModelAndView;
import com.cppba.service.UserService;
import com.cppba.entity.User;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 开发者
 * nickName:大黄蜂
 * email:245655812@qq.com
 * github:https://github.com/bigbeef
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/getById/{id}")
    @ResponseBody
    public User getById(HttpServletRequest request, HttpServletResponse response,
            @PathVariable Long id){
        User user = userService.get(id);
        return user;
    }

    @RequestMapping("/")
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response,ModelMap map){
        map.put("hello","from TemplateController.helloHtml");
        return new JModelAndView("index",map,request);
    }
}
