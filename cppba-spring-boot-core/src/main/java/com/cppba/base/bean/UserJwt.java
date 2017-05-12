package com.cppba.base.bean;

import lombok.Data;

@Data
public class UserJwt{

    private Long id;

    private String userName;

    private String[] roles;
}
