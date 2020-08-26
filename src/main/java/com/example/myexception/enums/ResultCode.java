package com.example.myexception.enums;

import lombok.Getter;

/**
 * @author linweiwei
 * @version 1.0
 * @date 2020-08-24 18:19
 * @describe:
 */


@Getter
public enum  ResultCode {

    SUCCESS(1000,"操作成功"),
    FAILED(1001, "操作失败"),
    VALIDATE_FAILED(1002, "参数错误"),
    ERROR(5000,"未知错误"),
    MY_EXCEPTION(10000, "自定义异常");

    private int code;
    private String message;

    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
