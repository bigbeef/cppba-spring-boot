package com.cppba.repository.custom;

import com.cppba.base.dao.BaseRepository;
import com.cppba.entity.ArticleClass;
import org.springframework.data.domain.Page;

/**
 * 开发者
 * nickName:大黄蜂
 * email:245655812@qq.com
 * github:https://github.com/bigbeef
 */
//用户自定义repository接口
public interface ArticleClassRepositoryCustom extends BaseRepository<ArticleClass,Long> {

    Page<ArticleClass> page(Long userId, String name, Integer pageNumber, Integer pageSize);

}
