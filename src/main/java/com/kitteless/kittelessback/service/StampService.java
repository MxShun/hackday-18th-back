package com.kitteless.kittelessback.service;

import com.kitteless.kittelessback.model.StampAuthorizeResponse;
import org.springframework.beans.factory.annotation.Autowired;

public class StampService {
    @Autowired
    PaymentRepository paymentRepository;

    public StampAuthorizeResponse stampAuthorize(String userId, String stampCord) {

        Payment payment = paymentRepository.findByUserId(userId);
        if(!payment.getStampCord().equals(stampCord)) {}

        StampAuthorizeResponse stampAuthorizeResponse = new StampAuthorizeResponse();
        stampAuthorizeResponse.setResult("success");
        return stampAuthorizeResponse;
    }
}
