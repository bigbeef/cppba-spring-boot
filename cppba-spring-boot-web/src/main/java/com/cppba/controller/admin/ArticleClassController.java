package com.cppba.controller.admin;

import com.cppba.controller.base.BaseController;
import com.cppba.service.ArticleClassService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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

}
