package com.kitteless.kittelessback.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ClovaOCRResponseFields {

    @JsonProperty("valueType")
    private String valueType;

    @JsonProperty("boundingPoly")
    private BoundingPoly boundingPoly;

    @JsonProperty("inferText")
    private String inferText;

    @JsonProperty("inferConfidence")
    private Integer inferConfidence;

    @JsonProperty("type")
    private String type;

    @JsonProperty("lineBreak")
    private String lineBreak;
}
