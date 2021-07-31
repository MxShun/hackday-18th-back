package com.kitteless.kittelessback.controller;

import com.kitteless.kittelessback.model.OcrResponse;
import com.kitteless.kittelessback.service.OcrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * 切手コード解析API
 */
@RestController
public class OcrController {
    @Autowired
    OcrService ocrService;

    // @GetMapping("/extract")
    @PostMapping("/extract")
    @ResponseStatus(HttpStatus.ACCEPTED)
//    public OcrResponse extract(String image) {
//        return ocrService.extract(image);
    public OcrResponse extract(@RequestBody String image) {
        return ocrService.extract(image);
    }
}
