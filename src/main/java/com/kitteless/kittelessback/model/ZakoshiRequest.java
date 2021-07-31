package com.kitteless.kittelessback.model;

import lombok.Data;

@Data
public class ZakoshiRequest {
    public OcrRequest message;
    public String file;
}
