package com.example.vo;

/**
 * @author linweiwei
 * @version 1.0
 * @date 2020-08-24 18:09
 * @describe: 前端同一返回类
 */
public class ResultVO<T> {

    //返回代码
    private String code;
    //返回信息
    private String message;
    //返回数据
    private T data;

    //构造方法
    public ResultVO(T data){

    }
}

