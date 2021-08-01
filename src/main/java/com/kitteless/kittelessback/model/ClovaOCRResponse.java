
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
    private List<ClovaOCRResponseImage> images;

}

@Data
class ClovaOCRResponseValidationResult {
    @JsonProperty("result")
    private String result;
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