package com.kitteless.kittelessback.controller;

import com.kitteless.kittelessback.model.RegisterResponse;
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
    UserService userService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public RegisterResponse register(@RequestBody User user) {
        return userService.register(user);
    }
}
