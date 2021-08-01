package com.kitteless.kittelessback.service;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ChargeService {
    public Map<Integer, String> getChargeList() {
        // TODO Repositoryと繋ぐ

        return Map.of(
                84, "定型郵便物：25g以内",
                94, "定型郵便物：50g以内"
        );
    }
}
