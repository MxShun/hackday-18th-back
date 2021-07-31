package com.kitteless.kittelessback.service;

import com.kitteless.kittelessback.model.StampAuthorizeResponse;
import com.kitteless.kittelessback.model.StampVerifyResponse;
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

    public StampVerifyResponse stampVerify(String image) {

        // TODO:OCRで画像をもとに9桁の切手コードを取得する

        // TODO:その切手コードをもとに決済テーブルから対象の決済を取得する

        // TODO:取得結果に応じてreturnする

        StampVerifyResponse stampVerifyResponse = new StampVerifyResponse();
        stampVerifyResponse.setResult("success");
        return stampVerifyResponse;
    }
}
