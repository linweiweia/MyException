package com.example.myexception.service.impl;



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
}
