package com.kitteless.kittelessback.controller;

import com.kitteless.kittelessback.model.StampAuthorizeRequest;
import com.kitteless.kittelessback.model.StampAuthorizeResponse;
import com.kitteless.kittelessback.model.StampVerifyResponse;
import com.kitteless.kittelessback.service.StampService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 切手コード認証API
 */

@RestController
@RequestMapping("/stamp")
public class StampController {

    @Autowired
    StampService stampService;

    @PostMapping("/authorize")
    public StampAuthorizeResponse stampAuthorize(@RequestBody StampAuthorizeRequest request){
        return stampService.stampAuthorize(request.getUserId(), request.getStampCode());
    }

    @PostMapping("/verify")
    public StampVerifyResponse verify(@RequestBody String image) {
        return stampService.stampVerify(image);
    }
}
