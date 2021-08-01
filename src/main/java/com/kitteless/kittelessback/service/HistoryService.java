package com.kitteless.kittelessback.service;

import com.kitteless.kittelessback.model.HistoryResponse;
import com.kitteless.kittelessback.model.Payment;
import com.kitteless.kittelessback.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class HistoryService {
//    TODO
//    @Autowired
//    PaymentRepository paymentRepository;

    public List<HistoryResponse> getHistory(String userId) {
        // Payment paymentRepository.findByUserId();

        HistoryResponse mockHitoryResponse = new HistoryResponse();
        mockHitoryResponse.setDateTime(LocalDateTime.now());
        mockHitoryResponse.setAmount(84);
        return List.of(
            mockHitoryResponse
        );
    }
}
