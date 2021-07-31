package com.kitteless.kittelessback.controller;

import com.kitteless.kittelessback.model.OcrResponse;
import com.kitteless.kittelessback.service.OcrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * OCR API
 */
@RestController
public class OcrController {
    @Autowired
    OcrService ocrService;

    @PostMapping("/extract")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public OcrResponse extract(String base64EncodedImage) {
        return ocrService.extract(base64EncodedImage);
    }
}
