package com.cppba.entity;

import com.cppba.base.entity.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 开发者
 * nickName:大黄蜂
 * email:245655812@qq.com
 * github:https://github.com/bigbeef
 */
@Data
@Entity
@Table(name = "user")
public class User extends BaseEntity {
    @Column(name = "user_name")
    private String userName;
    @Column(name = "password")
    private String password;
    @Column(name = "nick_name")
    private String nickName;
    @Column(name = "remark")
    private String remark;
    @Column(name = "title")
    private String title;
    @Column(name = "keyword")
    private String keyword;
    @Column(name = "description")
    private String description;
}
