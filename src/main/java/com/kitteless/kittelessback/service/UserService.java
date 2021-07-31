package com.kitteless.kittelessback.service;

import com.kitteless.kittelessback.model.User;
import com.kitteless.kittelessback.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public String register(User user) {
        userRepository.save(user);
        return "success";
    }
}
