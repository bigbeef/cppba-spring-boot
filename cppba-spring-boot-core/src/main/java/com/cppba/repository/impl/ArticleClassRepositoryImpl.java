package com.cppba.repository.impl;


import com.cppba.base.dao.impl.BaseRepositoryImpl;
import com.cppba.entity.ArticleClass;
import com.cppba.repository.custom.ArticleClassRepositoryCustom;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

/**
 * 开发者
 * nickName:大黄蜂
 * email:245655812@qq.com
 * github:https://github.com/bigbeef
 */
//用户自定义repository实现（命名必须以最顶层repository加后缀(默认Impl)规则，这里是UserRepository+Impl）
@Repository
public class ArticleClassRepositoryImpl extends BaseRepositoryImpl<ArticleClass,Long> implements ArticleClassRepositoryCustom {

    public Page<ArticleClass> page(Long userId, String name, Integer pageNumber, Integer pageSize){
        String HQL = "select ac from ArticleClass ac where 1=1 and ac.deleteStatus=0 ";
        HashMap<String, Object> params = Maps.newHashMap();
        if(userId != null){
            HQL += " and ac.user.id = :userId ";
            params.put("userId",userId);
        }
        if(StringUtils.isNotBlank(name)){
            HQL += " and ac.name like :name ";
            params.put("name","%"+name+"%");
        }
        HQL += " order by ac.sort";
        return this.pageByHql(HQL,params,pageNumber,pageSize);
    }

}
