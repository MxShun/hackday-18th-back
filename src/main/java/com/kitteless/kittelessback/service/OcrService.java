package com.kitteless.kittelessback.service;

import com.kitteless.kittelessback.model.OcrResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OcrService {

    public OcrResponse extract(String base64EncodedImage) {

        // FIXME: OcrRepository を呼んでないので呼ぶ

        OcrResponse ocrResponse = new OcrResponse();
        ocrResponse.setResult("success");
        ocrResponse.setValue("123456789");
        return ocrResponse;
    }
}
