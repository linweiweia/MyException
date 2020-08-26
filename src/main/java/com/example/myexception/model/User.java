package com.example.myexception.model;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author linweiwei
 * @version 1.0
 * @date 2020-08-25 13:15
 * @describe:
 */

@Data
public class User {

    @NotNull(message = "用户Id不能为空")
    private Long id;

    @NotNull(message = "用户账号不能为空")
    @Size(min = 6, max = 12, message = "用户名长度6到12")
    private String account;

    @NotNull(message = "用户密码不能为空")
    @Size(min = 6, max = 12, message = "用户密码长度6到12")
    private String password;

    @NotNull(message = "用户邮箱不能为空")
    @Email(message = "邮箱格式不正确")
    private String email;

}
