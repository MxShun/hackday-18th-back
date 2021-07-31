
package com.kitteless.kittelessback.model;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import java.util.List;

@Data
public class ClovaOCRResponse {

    @JsonProperty("version")
    private String version;
    @JsonProperty("requestId")
    private String requestId;
    @JsonProperty("timestamp")
    private Long timestamp;
    @JsonProperty("images")
    private List<ClovaOCRResponseImage> images = null;

}

@Data
class ClovaOCRResponseImage {
    @JsonProperty("uid")
    private String uid;

    @JsonProperty("name")
    private String name;

    @JsonProperty("inferResult")
    private String inferResult;

    @JsonProperty("message")
    private String message;

    @JsonProperty("validationResult")
    private ClovaOCRResponseValidationResult validationResult;
}

@Data
class ClovaOCRResponseValidationResult {
    @JsonProperty("result")
    private String result;
}