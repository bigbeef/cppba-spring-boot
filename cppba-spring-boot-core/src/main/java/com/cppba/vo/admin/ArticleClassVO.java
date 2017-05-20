package com.cppba.vo.admin;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ArticleClassVO {

    private Long userId;

    private String name;

    private String sort;
}
