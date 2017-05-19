package com.cppba.base.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 开发者
 * nickName:大黄蜂
 * email:245655812@qq.com
 * github:https://github.com/bigbeef
 */
@NoRepositoryBean
public interface BaseRepository<T, ID extends Serializable> {

    int executeUpdate(String hql);

    List<T> findByHql(final String hql);

    List<T> findByHql(final String hql, final Map params);

    Page<T> pageByHql(final String hql, final Integer page, final Integer size);

    Page<T> pageByHql(final String hql, final Map params, final Integer page, final Integer size);

    Page<T> pageByHql(final String hql, final Map params, final Integer page, final Integer size,final Sort sort);

    Long count(final String hql, final Map params);

}
