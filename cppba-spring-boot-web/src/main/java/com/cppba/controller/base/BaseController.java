package com.cppba.controller.base;

import com.cppba.base.bean.UserJwt;

import javax.servlet.http.HttpServletRequest;

public class BaseController {
    public UserJwt getCurrentUser(HttpServletRequest request){
        return (UserJwt) request.getAttribute("user");
    }
}
