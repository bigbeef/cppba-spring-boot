package com.cppba.controller.base;

import com.cppba.base.bean.CurrentUser;

import javax.servlet.http.HttpServletRequest;

public class BaseController {
    public CurrentUser getCurrentUser(HttpServletRequest request){
        return (CurrentUser) request.getAttribute("user");
    }
}
