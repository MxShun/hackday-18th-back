package com.kitteless.kittelessback.service;

import com.kitteless.kittelessback.model.OcrResponse;
import com.kitteless.kittelessback.repository.OcrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OcrService {
    @Autowired
    OcrRepository ocrRepository;

    public OcrResponse extract(String base64EncodedImage) {
        String result = ocrRepository.read(base64EncodedImage);

        OcrResponse ocrResponse = new OcrResponse();
        ocrResponse.setResult("success");
        ocrResponse.setText(result);
        return ocrResponse;
    }
}
