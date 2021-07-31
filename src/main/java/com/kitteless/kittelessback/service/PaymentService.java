package com.kitteless.kittelessback.service;

import com.kitteless.kittelessback.model.PaymentResponse;
import com.kitteless.kittelessback.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    @Autowired
    PaymentRepositry paymentRepositry;

    public PaymentResponse payment(Payment payment) {
        paymentRepositry.save(payment);

        PaymentResponse paymentResponse = new PaymentResponse();
        paymentResponse.setResult("success");
        return paymentResponse;
    }
}
