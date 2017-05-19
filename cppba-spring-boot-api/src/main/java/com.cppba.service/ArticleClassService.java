package com.cppba.service;


import com.cppba.base.bean.Result;

public interface ArticleClassService {
    Result page(Long userId, String name, Integer pageNumber, Integer pageSize);
}
