package com.kitteless.kittelessback.model;

import lombok.Data;

@Data
public class StampAuthorizeRequest {
    String userId;
    String stampCode;
}
