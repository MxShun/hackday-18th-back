package com.kitteless.kittelessback.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {
    @Autowired
    RegisterRepository registerRepository

    public String register(User user) {
        return registerRepository.insert(user);
    }
}
