package com.kitteless.kittelessback.controller;

import com.kitteless.kittelessback.service.ChargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ChargeController {
    @Autowired
    ChargeService chargeService;

    @PostMapping("/charge")
    @ResponseStatus(HttpStatus.OK)
    public Map<Integer, String> getChargeList() {
        return chargeService.getChargeList();
    }
}
