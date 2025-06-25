package com.springboot.springbootdemo.controller;

import com.springboot.springbootdemo.model.User;
import com.springboot.springbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
     private UserService userService;

    @GetMapping
    public String listUser(Model model) {
        model.addAttribute("users",userService.getAllUsers());
        return "user-list";
    }

    @GetMapping("/add")
    public String addUserForm(Model model) {
        model.addAttribute("user",new User());
        return "add-user";

    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    public String editUserForm(@PathVariable int id, Model model){
        userService.getUserById(id).
                ifPresent(user -> model.addAttribute("user",user));
        return "edit-user";
    }

    @PostMapping("/update")
    public String updateUser(@ModelAttribute User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }

}
