package com.kitteless.kittelessback.service;

import com.kitteless.kittelessback.model.Payment;
import com.kitteless.kittelessback.model.PaymentResponse;
import com.kitteless.kittelessback.model.User;
import com.kitteless.kittelessback.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class PaymentService {
    @Autowired
    PaymentRepository paymentRepository;

    public PaymentResponse payment(Payment payment) {
        String stampCode = generateStampCode();
        // ここで重複ないかのチェックは必要
        payment.setStampCode(stampCode);

        paymentRepository.save(payment);

        PaymentResponse paymentResponse = new PaymentResponse();
        paymentResponse.setStampCode(stampCode);
        paymentResponse.setPaymentResult("success");
        return paymentResponse;
    }

    // 9桁の数字をランダム生成(桁数合わせるためにゼロパディング)
    private String generateStampCode(){
        String stampCode = "";
        Random rand = new Random();
        stampCode = Integer.toString(new Random().nextInt(899999999) + 100000000);
        return stampCode;
    }
}
