package com.kitteless.kittelessback.service;

import com.kitteless.kittelessback.model.StampAuthorizeResponse;
import org.springframework.beans.factory.annotation.Autowired;

public class StampService {
    @Autowired
    //リポジトリを記述

    public StampAuthorizeResponse stampAuthorize(String userId, String stampCord){

        //レコードに保存

        StampAuthorizeResponse stampAuthorizeResponse = new StampAuthorizeResponse();
        stampAuthorizeResponse.setResult("success");
        return stampAuthorizeResponse;
    }
}
