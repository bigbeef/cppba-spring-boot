package com.cppba.base.bean;

import lombok.Data;

@Data
public class CurrentUser{

    private Long id;

    private String userName;

    private String[] roles;
}
