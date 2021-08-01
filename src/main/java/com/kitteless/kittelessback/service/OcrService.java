package com.kitteless.kittelessback.service;

import com.kitteless.kittelessback.model.ClovaOCRResponse;
import com.kitteless.kittelessback.model.ClovaOCRResponseFields;
import com.kitteless.kittelessback.model.OcrResponse;
import com.kitteless.kittelessback.repository.OcrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class OcrService {
    @Autowired
    OcrRepository ocrRepository;

    public OcrResponse extract(String image) {
        OcrRepository ocr = new OcrRepository();
        ClovaOCRResponse response = ocr.read(image);

        if (response == null) {
            OcrResponse ocrResponse = new OcrResponse();
            ocrResponse.setResult("failure");
            return ocrResponse;
        }

        String text = response
                .getImages().stream().findFirst().get() // 空だと NoSuchElementException
                .getFields().stream().map(ClovaOCRResponseFields::getInferText).collect(Collectors.joining());

        System.out.println("----OCRRESPONSE----");
        System.out.println(response.toString());
        System.out.println("----INFERTEXT----");
        System.out.println(text);

        OcrResponse ocrResponse = new OcrResponse();
        ocrResponse.setResult("success");
        ocrResponse.setText(text);
        return ocrResponse;
    }
}
