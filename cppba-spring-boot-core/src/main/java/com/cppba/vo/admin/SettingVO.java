package com.cppba.vo.admin;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SettingVO {

    private String nickName;

    private String remark;

    private String title;

    private String keyword;

    private String description;
}
