package com.cppba.service.impl;

import com.cppba.repository.ArticleClassRepository;
import com.cppba.service.ArticleClassService;
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
public class ArticleClassServiceImpl implements ArticleClassService {

    @Resource
    private ArticleClassRepository articleClassRepository;


}
