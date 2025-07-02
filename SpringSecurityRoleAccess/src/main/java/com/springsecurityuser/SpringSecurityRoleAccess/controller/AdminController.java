package com.springsecurityuser.SpringSecurityRoleAccess.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin/")
public class AdminController {

    @GetMapping("/dashboard")
    public String dashboard() {
        return "Welcome admin this is your dashboard page";
    }
}
