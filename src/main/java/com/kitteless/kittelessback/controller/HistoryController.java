package com.kitteless.kittelessback.controller;

import com.kitteless.kittelessback.model.HistoryList;
import com.kitteless.kittelessback.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HistoryController {
    @Autowired
    HistoryService historyService;

    @PostMapping("/history")
    @ResponseStatus(HttpStatus.OK)
    public HistoryList getHistory(String userId) {
        HistoryList historyList = new HistoryList();
        historyList.setHistoryResponseList(historyService.getHistory(userId));
        return historyList;
    }
}
