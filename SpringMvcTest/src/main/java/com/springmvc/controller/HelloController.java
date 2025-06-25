package com.springmvc.controller;

import com.springmvc.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class HelloController {

    @RequestMapping("/mypage")
    public String home(Model model) {


        String name = "amit";
        List<String> list = new ArrayList<String>();
        list.add("ramesh");
        list.add("amit");
        System.out.println(list);
        model.addAttribute("uname",name);
        model.addAttribute("numlist",list);
        //model.addAttribute("user",user);
        System.out.println("This is home controller method");
        return "home";
    }

    @RequestMapping("/about")
    public String aboutPage(Model model) {
        return "about";
    }
}
