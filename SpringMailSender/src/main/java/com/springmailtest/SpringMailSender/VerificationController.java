package com.springmailtest.SpringMailSender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VerificationController {

    @Autowired
    UserRepository userRepository;
    @GetMapping("/verify")
    @ResponseBody
    public String verifyMail(@RequestParam("token") String token) {
        User  user = userRepository.findByToken(token);
        if(user!=null && !user.isVerified()) {
            user.setVerified(true);
            user.setToken(null);
            userRepository.save(user);
            return "Your mail has been succesffuly verified";
        }
            return "Invalid or expired token";
    }
}
