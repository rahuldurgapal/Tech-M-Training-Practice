package com.springsecurityuser.SpringSecurityRoleAccess.service;

import com.springsecurityuser.SpringSecurityRoleAccess.model.User;
import com.springsecurityuser.SpringSecurityRoleAccess.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User register(User user) {
        return userRepository.save(user);
    }

    public Optional<User> getUserByName(String username) {
        return userRepository.findByUsername(username);
    }
}
