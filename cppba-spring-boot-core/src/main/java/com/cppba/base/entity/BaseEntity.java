package com.cppba.base.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 开发者
 * nickName:大黄蜂
 * email:245655812@qq.com
 * github:https://github.com/bigbeef
 */
@Data
@MappedSuperclass
public class BaseEntity implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "add_time", columnDefinition = "timestamp default current_timestamp")
    private Date addTime;
    @Column(name = "delete_status", columnDefinition = "0")
    private Integer deleteStatus;
}
