package com.example.myexception.exception;

/**
 * @author linweiwei
 * @version 1.0
 * @date 2020-08-26 14:34
 * @describe:  自定义异常抛出类
 */
public class ExceptionCast {

    public static void cast(){
        throw new MyException();
    }

    public static void cast(String message){
        throw new MyException(message);
    }
}
