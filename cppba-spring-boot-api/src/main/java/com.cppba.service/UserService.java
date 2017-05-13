package com.cppba.service;


import com.cppba.base.bean.Result;
import com.cppba.form.admin.SettingForm;

public interface UserService {

    Result login(String UserName, String password) throws Exception;

    Result setting(Long id);

    Result settingUpdate(Long id,SettingForm settingFrom);
}
