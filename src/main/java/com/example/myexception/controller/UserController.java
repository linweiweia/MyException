package com.example.myexception.controller;

import com.example.myexception.model.User;
import com.example.myexception.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author linweiwei
 * @version 1.0
 * @date 2020-08-25 11:27
 * @describe:
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/addUser")
    public String addUser(@RequestBody @Valid User user) {
        return userService.addUser(user);
    }


    @GetMapping("/get")
    public void get() {
        System.out.println("get");
    }
}
