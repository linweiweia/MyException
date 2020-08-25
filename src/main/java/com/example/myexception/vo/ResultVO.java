package com.example.myexception.vo;

import com.example.myexception.enums.ResultCode;
import lombok.Getter;

/**
 * @author linweiwei
 * @version 1.0
 * @date 2020-08-25 13:17
 * @describe:
 */

@Getter
public class ResultVO<T> {
    //返回代码
    private int code;
    //返回信息
    private String message;
    //返回数据
    private T data;

    //构造方法
    public ResultVO(ResultCode resultCode, T data) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
        this.data = data;
    }
}
