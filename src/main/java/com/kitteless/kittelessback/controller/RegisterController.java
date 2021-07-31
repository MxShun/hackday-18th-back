package com.kitteless.kittelessback.controller;

import com.kitteless.kittelessback.model.User;
import com.kitteless.kittelessback.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * アカウント登録API
 */
@RestController
public class RegisterController {
    @Autowired
    UserService registerService;

    @GetMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    // TODO 戻り値後で考える
    //public String register(@RequestBody User user) {
    public String register() {
        User user = new User();
        user.setId("11111");
        user.setName("HOGE");
        user.setPassword("aaa");
        return registerService.register(user);
    }
}
