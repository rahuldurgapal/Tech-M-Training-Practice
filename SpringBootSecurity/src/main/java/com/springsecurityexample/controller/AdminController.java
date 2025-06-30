package com.springsecurityexample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/")
public class AdminController {

    @GetMapping("/home")
    public String home() {
        return "This is admin home page";
    }

    @GetMapping("/profile")
    public String profile() {
        return "This is admin profile page";
    }

}
