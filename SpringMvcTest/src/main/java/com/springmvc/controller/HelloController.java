package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @RequestMapping("/mypage")
    public String home() {
        System.out.println("This is home controller method");
        return "home";
    }

    @RequestMapping("/about")
    public String aboutPage() {
        return "about";
    }
}
