package com.kitteless.kittelessback.controller;

import com.kitteless.kittelessback.model.PaymentResponse;
import com.kitteless.kittelessback.service.PaymentService;
import com.kitteless.kittelessback.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * 決済API
 */
@RestController
public class PaymentController {
    @Autowired
    PaymentService paymentService;

    @PostMapping("/payment")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public PaymentResponse payment(@RequestBody Payment payment) {
        return paymentService.payment(payment);
    }
