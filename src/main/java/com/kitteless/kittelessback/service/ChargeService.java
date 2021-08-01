package com.kitteless.kittelessback.service;

import com.kitteless.kittelessback.model.ChargeResponse;
import com.kitteless.kittelessback.model.PostalCharge;
import com.kitteless.kittelessback.repository.PostalChargeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ChargeService {
    @Autowired
    PostalChargeRepository postalChargeRepository;

    public List<ChargeResponse> getChargeList() {
        List<PostalCharge> postalChargeList = postalChargeRepository.findAll();

        return postalChargeList.stream()
                .map(postalCharge -> {
                    ChargeResponse chargeResponse = new ChargeResponse();
                    chargeResponse.setAmount(postalCharge.getAmount());
                    chargeResponse.setStandard(postalCharge.getStndard());
                    return chargeResponse;
                })
                .collect(Collectors.toList());
    }
}
