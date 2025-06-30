package com.springsecurityexample.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/")
public class UserController {

    @GetMapping("/add")
    public String add(){
        return "User add Succesfully";
    }

    @GetMapping("/update")
    public String update(){
        return "user update successfully";
    }
}
