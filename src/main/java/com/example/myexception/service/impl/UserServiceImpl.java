package com.example.myexception.service.impl;



import com.example.myexception.exception.ExceptionCast;
import com.example.myexception.model.User;
import com.example.myexception.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author RC
 * @description 用户业务实现类
 */
@Service
public class UserServiceImpl implements UserService {

    @Override
    public String addUser(User user) {
        // 直接编写业务逻辑
        return "success";
    }


    /**
     * 自定义异常测试
     */
    public String myException() {
        //ExceptionCast.cast();
        //就很方便想返回什么直接在参数里写
        ExceptionCast.cast("我是自定义异常信息");
        //就不会执行了
        return "wefwe";
    }

}
