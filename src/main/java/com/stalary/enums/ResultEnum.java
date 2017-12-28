package com.stalary.enums;

/**
 * @author Stalary
 * @description
 * @date 2017/10/25
 */
public enum ResultEnum {
    UNKNOW_ERROR(-2, "未知错误"),
    SUCCESS(0, "成功"),
    NEED_LOGIN(-3, "未登录"),
    PRIMARY_SCHOOL(100, "你可能还在上小学"),
    MIDDLE_SCHOOL(101, "你可能在上初中");

    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
