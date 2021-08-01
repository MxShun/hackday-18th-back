package com.kitteless.kittelessback.controller;

import com.kitteless.kittelessback.model.HistoryResponse;
import com.kitteless.kittelessback.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HistoryController {
    @Autowired
    HistoryService historyService;

    @PostMapping("/history")
    @ResponseStatus(HttpStatus.OK)
    public List<HistoryResponse> getHistory(String userId) {
        return historyService.getHistory(userId);
    }
}
