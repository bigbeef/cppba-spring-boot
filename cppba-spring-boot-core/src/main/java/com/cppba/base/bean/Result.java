package com.cppba.base.bean;

import lombok.Data;

import java.util.Map;

@Data
public class Result extends BaseBean{

    private static final long serialVersionUID = 1L;

    public boolean             success;              // 成功标志
    public Integer             code;                 // 返回标示
    public String              msg;                  // 相关消息
    public Object              data;                 // 相关数据
    public Map<String, Object> errors;               // 错误详细

    public Result() {
        super();
    }

    public Result(boolean success) {
        this.success = success;
    }

    public Result(boolean success, Integer code, Object data, String msg) {
        this(success);
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public Result(Integer code, Map<String, Object> errors, String msg) {
        this.success = false;
        this.code = code;
        this.errors = errors;
        this.msg = msg;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public boolean hasErrors() {
        if (this.errors != null && this.errors.size() > 0) {
            return true;
        }
        return false;
    }

}
