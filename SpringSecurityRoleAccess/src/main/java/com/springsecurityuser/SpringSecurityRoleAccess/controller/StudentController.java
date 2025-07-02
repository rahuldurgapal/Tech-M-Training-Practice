package com.springsecurityuser.SpringSecurityRoleAccess.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student/")
public class StudentController {

    @GetMapping("/profile")
    public String profile() {
        return "This is student profile page";
    }
}
