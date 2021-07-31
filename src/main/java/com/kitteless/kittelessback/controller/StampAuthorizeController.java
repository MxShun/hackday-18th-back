package com.kitteless.kittelessback.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 切手コード認証API
 */

@RestController
public class StampAuthorizeController {

    @Autowired
    StampService stampService;

    @PostMapping("/stamp/authorize")
    public StampAuthorizeResponse stampAuthorize(@RequestBody String userId,
                                                 @RequestBody String stampCode){
        return stampService.stampAuthorize(userId, stampCode);
    }

}
