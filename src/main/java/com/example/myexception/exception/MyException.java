package com.example.myexception.exception;

import lombok.Data;

/**
 * @author linweiwei
 * @version 1.0
 * @date 2020-08-26 14:11
 * @describe:  自定义异常类
 */

@Data
public class MyException extends RuntimeException{

    private int code;
    private String message;

    public MyException() {
        this(1001, "我是自定义错误");
    }


    public MyException(String message) {
        this(1001, message);
    }

    public MyException(int code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }
}
