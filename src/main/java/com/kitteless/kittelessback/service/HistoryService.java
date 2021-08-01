package com.kitteless.kittelessback.service;

import com.kitteless.kittelessback.model.HistoryResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class HistoryService {
//    TODO Repository実装
//    @Autowired
//    PaymentRepository paymentRepository;

    public List<HistoryResponse> getHistory() {
        // TODO Repository実装

        HistoryResponse mockHitoryResponse = new HistoryResponse();
        mockHitoryResponse.setDateTime(LocalDateTime.now());
        mockHitoryResponse.setAmount(84);
        return List.of(
            mockHitoryResponse
        );
    }
}
