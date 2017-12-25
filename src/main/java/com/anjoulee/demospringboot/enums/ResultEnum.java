package com.anjoulee.demospringboot.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {
    UNKNOWN_ERROR(-1, "未知错误"),
    SUCCESS(0, "成功"),
    PRIMARY_SCHOOL(100, "你可能还在上小学"),
    MIDDLE_SCHOOL(101, "你可能在上初中");

    //代码
    private Integer code;

    //描述
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
