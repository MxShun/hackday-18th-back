package com.kitteless.kittelessback.service;

import com.kitteless.kittelessback.model.HistoryResponse;
import com.kitteless.kittelessback.model.Payment;
import com.kitteless.kittelessback.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HistoryService {
    @Autowired
    PaymentRepository paymentRepository;

    public List<HistoryResponse> getHistory(String userId) {
        List<Payment> paymentList = paymentRepository.findPaymentsByUserId(userId);

        return paymentList.stream()
                .map(payment -> {
                    HistoryResponse historyResponse = new HistoryResponse();
                    historyResponse.setDateTime(payment.getDateTime());
                    historyResponse.setAmount(payment.getAmount());
                    return historyResponse;
                })
                .collect(Collectors.toList());
    }
}
