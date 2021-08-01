package com.kitteless.kittelessback.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ClovaOCRResponseImage {
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

    @JsonProperty("fields")
    private List<ClovaOCRResponseFields> fields;
}
