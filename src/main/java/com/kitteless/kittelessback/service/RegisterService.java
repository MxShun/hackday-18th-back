package com.kitteless.kittelessback.service;

import com.kitteless.kittelessback.model.User;
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
