package com.cppba.base.dao.impl;

import com.cppba.base.dao.BaseRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 开发者
 * nickName:大黄蜂
 * email:245655812@qq.com
 * github:https://github.com/bigbeef
 */
public class BaseRepositoryImpl<T, ID extends Serializable> implements BaseRepository<T,ID> {

    @PersistenceContext
    private EntityManager em;

    public int executeUpdate(String hql){
        Query query = em.createQuery(hql);
        return query.executeUpdate();
    }

    public List<T> findByHql(final String hql){
        return findByHql(hql,null);
    }

    public List<T> findByHql(final String hql, final Map params) {
        return pageByHql(hql,params,0,0).getContent();
    }

    public Page<T> pageByHql(final String hql, final Integer page, final Integer size){
        return pageByHql(hql,null,page,size);
    }

    public Page<T> pageByHql(final String hql, final Map params, final Integer page, final Integer size) {
        return pageByHql(hql,params,page,size,null);
    }

    public Page<T> pageByHql(final String hql, final Map params, final Integer page, final Integer size,final Sort sort){
        StringBuilder sqlBuilder = new StringBuilder(hql);
        PageRequest pageRequest;
        List list;
        Integer count;

        //排序
        if(sort != null){
            int i = 0;
            for (Sort.Order order : sort) {
                if(i==0){
                    sqlBuilder.append(" order by "+order.getProperty()+" "+order.getDirection().name()+" ");
                }else{
                    sqlBuilder.append(","+order.getProperty()+" "+order.getDirection().name()+" ");
                }
                i++;
            }
        }

        Query query = em.createQuery(sqlBuilder.toString());
        //参数
        if (params != null && params.size() > 0) {
            for (Object key : params.keySet()) {
                query.setParameter(key.toString(), params.get(key));
            }
        }

        if(page>0 && size>0){
            query.setFirstResult((page - 1) * size);
            query.setMaxResults(size);

            list= query.getResultList();
            count = count(hql,params).intValue();
            pageRequest = new PageRequest(page, size);
        }else{
            list= query.getResultList();
            count = list.size();
            pageRequest = new PageRequest(1,count);
        }
        return new PageImpl<T>(list,pageRequest,count);
    }

    public Long count(final String hql, final Map params) {
        final String countHQL = prepareCountHql(hql);
        Query query = em.createQuery(countHQL);
        if (params != null && params.size() > 0) {
            for (Object key : params.keySet()) {
                query.setParameter(key.toString(), params.get(key));
            }
        }
        return (Long)query.getSingleResult();
    }

    //获取HQL的count(*)
    private String prepareCountHql(final String HQL) {
        String fromHql = HQL;
        fromHql = "from" + StringUtils.substringAfter(fromHql, "from");
        fromHql = StringUtils.substringBefore(fromHql, "order by");
        int whereIndex = fromHql.indexOf("where");
        int leftIndex = fromHql.indexOf("left join");
        if (leftIndex >= 0) {
            if (whereIndex >= 0) {
                String temp = StringUtils.substringBefore(fromHql, "left");
                fromHql = temp + " where "
                        + StringUtils.substringAfter(fromHql, "where");
            } else {
                fromHql = StringUtils.substringBefore(fromHql, "left");
            }
        }
        return "select count(*) " + fromHql;
    }
}