package com.cppba.base.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;


@NoRepositoryBean
public interface BaseRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {
    /*int executeUpdate(String hql);

    List<T> findByHql(final String hql, final Map params);

    Page<T> pageByHql(final String hql, final Map params, final Integer page, final Integer size);

    Long count(final String hql, final Map params);*/

}
