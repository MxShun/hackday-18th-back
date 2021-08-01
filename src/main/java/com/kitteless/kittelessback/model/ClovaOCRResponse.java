
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

    @JsonProperty("fields")
    private List<ClovaOCRResponseFields> fields;
}

@Data
class ClovaOCRResponseValidationResult {
    @JsonProperty("result")
    private String result;
}

@Data
class ClovaOCRResponseFields {

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

@Data
class BoundingPoly {
    @JsonProperty("vertices")
    private List<Vertices> vertices;
}

@Data
class Vertices {
    @JsonProperty("x")
    private Integer x;

    @JsonProperty("y")
    private Integer y;
}