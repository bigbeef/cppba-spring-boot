package com.cppba.repository;


import com.cppba.entity.ArticleClass;
import com.cppba.repository.custom.ArticleClassRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 开发者
 * nickName:大黄蜂
 * email:245655812@qq.com
 * github:https://github.com/bigbeef
 */
//同时继承base和自定义repository,自定义接口实现命名必须以此接口名加后缀
public interface ArticleClassRepository extends ArticleClassRepositoryCustom,JpaRepository<ArticleClass,Long> {

}
