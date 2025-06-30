package com.springsecurityexample.controller;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home(HttpServletRequest request) {
        return "This is home page " + request.getSession().getId();
    }

    @GetMapping("/about")
    public String about() {
        return "This is about page";
    }
}

