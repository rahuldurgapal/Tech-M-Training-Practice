package com.springsecurityexample.service;

import com.springsecurityexample.model.User;
import com.springsecurityexample.repositlry.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User register(User user) {
        return userRepository.save(user);
    }

    public User getUserByName(String username) {
        return userRepository.findByUsername(username);
    }
}
