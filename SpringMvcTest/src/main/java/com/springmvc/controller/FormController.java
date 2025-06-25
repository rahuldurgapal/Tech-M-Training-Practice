package com.springmvc.controller;

import com.springmvc.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormController {

    @RequestMapping("form")
    public String showForm() {
        return "form";
    }

//    @RequestMapping(path = "/save", method = RequestMethod.POST)
//    public String saveForm(@RequestParam("userEmail") String email, @RequestParam("password") String password) {
//        System.out.println("User Email is: "+email);
//        System.out.println("User Password is: "+password);
//        return "home";
//
//    }

    @RequestMapping(path = "/save", method = RequestMethod.POST)
    public String saveForm(@ModelAttribute User user,Model model) {
        System.out.println("User Email is: "+ user.email1);
        System.out.println("User Password is: "+user.password1);
        System.out.println("User age is: " + user.age);
        System.out.println("User Address is: " + user.address);
        User u1 = userService.add(user);
        model.addAttribute("user",u1);

        return "form";

    }


}
