package com.example.myexception.config;

import com.example.myexception.enums.ResultCode;
import com.example.myexception.exception.MyException;
import com.example.myexception.vo.ResultVO;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author linweiwei
 * @version 1.0
 * @date 2020-08-25 11:39
 * @describe: 全局异常处理类（包括框架抛出的异常入参数检查和自定义异常）
 */

@RestControllerAdvice
public class ExceptionControllerAdvice {

    /**
     * 框架抛出的异常
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultVO<String> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        // 从异常对象中拿到ObjectError对象
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
        // 然后提取错误提示信息进行返回
        return new ResultVO<>(ResultCode.VALIDATE_FAILED, objectError.getDefaultMessage());
    }


    /**
     * 自定义异常
     * @param myException
     * @return
     */
    @ExceptionHandler(MyException.class)
    public ResultVO<String> myExceptionHandle(MyException myException) {
        return new ResultVO<>(ResultCode.MY_EXCEPTION, myException.getMessage());
    }
}
