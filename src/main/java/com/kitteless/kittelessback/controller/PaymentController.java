package com.kitteless.kittelessback.controller;

import com.kitteless.kittelessback.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * 決済API
 */
@RestController
public class PaymentController {
    @Autowired
    UserService userService;
}
