package com.kitteless.kittelessback.service;

import com.kitteless.kittelessback.model.OcrResponse;
import com.kitteless.kittelessback.model.Payment;
import com.kitteless.kittelessback.model.StampAuthorizeResponse;
import com.kitteless.kittelessback.model.StampVerifyResponse;
import com.kitteless.kittelessback.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StampService {
    @Autowired
    PaymentRepository paymentRepository;

    public StampAuthorizeResponse stampAuthorize(String userId, String stampCord) {

        Payment payment = paymentRepository.findByStampCord(stampCord);
        if(!payment.getUserId().equals(userId)) {}

        StampAuthorizeResponse stampAuthorizeResponse = new StampAuthorizeResponse();
        stampAuthorizeResponse.setResult("success");
        return stampAuthorizeResponse;
    }

    public StampVerifyResponse stampVerify(String image) {

        OcrService ocrService = new OcrService();
        OcrResponse ocrResponse = ocrService.extract(image);

        Payment payment = paymentRepository.findByStampCord(ocrResponse.getValue());

        String result = payment.getUserId() != null ? "success" : "failure";

        StampVerifyResponse stampVerifyResponse = new StampVerifyResponse();
        stampVerifyResponse.setResult(result);
        return stampVerifyResponse;
    }
}
