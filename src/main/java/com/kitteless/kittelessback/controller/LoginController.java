package com.kitteless.kittelessback.controller;

import com.kitteless.kittelessback.model.LoginResponse;
import com.kitteless.kittelessback.model.RegisterResponse;
import com.kitteless.kittelessback.model.User;
import com.kitteless.kittelessback.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * ログイン画面
 */
@RestController
public class LoginController {
    @Autowired
    UserService userService;

    @GetMapping(value = "/login")
//    public LoginResponse login(@RequestBody User user) {

    public LoginResponse login() {
        User user = new User();
        user.setName("hoge");
        user.setPassword("fuga");

        return userService.login(user);
    }
}
