package com.kitteless.kittelessback.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class HistoryResponse {
    LocalDateTime dateTime;
    Integer amount;
}
