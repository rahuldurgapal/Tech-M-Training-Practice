package com.springsecurityexample.controller;


import com.springsecurityexample.model.User;
import com.springsecurityexample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user/")
public class UserController {

    @Autowired
    private UserService userService;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(5);
    @GetMapping("/add")
    public String add(){
        return "User add Succesfully";
    }

    @PostMapping("/register")
   public ResponseEntity<User> registerUser(@RequestBody User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return ResponseEntity.ok(userService.register(user));
   }

    @GetMapping("/update")
    public String update(){
        return "user update successfully";
    }
}
