package com.example.enums;

/**
 * @author linweiwei
 * @version 1.0
 * @date 2020-08-24 18:19
 * @describe:
 */
public enum  ResultCode {

    ;
    private int code;
    private String message;

    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
