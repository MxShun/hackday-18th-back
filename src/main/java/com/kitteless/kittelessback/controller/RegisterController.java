package com.kitteless.kittelessback.controller;

import com.kitteless.kittelessback.model.User;
import com.kitteless.kittelessback.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * アカウント登録API
 */
@Controller
public class RegisterController {
    @Autowired
    RegisterService registerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    // TODO 戻り値後で考える
    public String register(@RequestBody User user) {
        return registerService.register(user);
    }
}
