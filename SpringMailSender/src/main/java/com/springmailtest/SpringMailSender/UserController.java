package com.springmailtest.SpringMailSender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    EmailService emailService;

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        UUID token = UUID.randomUUID();
        String token1 = token.toString();
        user.setToken(token1);
        user.setVerified(false);
      userRepository.save(user);
      emailService.sendEmailVerification(user.getEmail(),token1);

      return "User Registered succesfully please check you mail to verify you email";
    }
}
