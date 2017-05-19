package com.cppba.controller.admin;

import com.cppba.base.annotation.RequiresRoles;
import com.cppba.base.bean.CurrentUser;
import com.cppba.base.bean.Result;
import com.cppba.controller.base.BaseController;
import com.cppba.service.ArticleClassService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
@RequestMapping("/admin/articleClass")
public class ArticleClassController extends BaseController {

    @Resource
    private ArticleClassService articleClassService;

    @ResponseBody
    @RequiresRoles({"login"})
    @RequestMapping("/page")
    public Result page(
            HttpServletRequest request,
            @RequestParam(name = "pageNumber",defaultValue = "0") Integer pageNumber,
            @RequestParam(name = "pageSize",defaultValue = "0")Integer pageSize,
            @RequestParam(name = "name",defaultValue = "")String name) {
        CurrentUser currentUser = getCurrentUser(request);
        return articleClassService.page(currentUser.getId(),name,pageNumber,pageSize);
    }

}
