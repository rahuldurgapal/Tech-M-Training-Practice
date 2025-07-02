package com.springsecurityuser.SpringSecurityRoleAccess.controller;

import com.springsecurityuser.SpringSecurityRoleAccess.model.Role;
import com.springsecurityuser.SpringSecurityRoleAccess.model.User;
import com.springsecurityuser.SpringSecurityRoleAccess.service.RoleService;
import com.springsecurityuser.SpringSecurityRoleAccess.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
public class RegistrationController {

    @Autowired
  private UserService userService;

    @Autowired
  private RoleService roleService;

  private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    @PostMapping("register/{role}")
    public String register(@RequestBody User user, @PathVariable String role) {
        if(userService.getUserByName(user.getUsername()).isPresent()) {
            return " Username already exists: ";
        }
        user.setPassword(encoder.encode(user.getPassword()));

        Role role1 = roleService.getRoleByName(role)
                .orElseThrow(() -> new RuntimeException("Role not found"));
        user.setRoles(Collections.singletonList(role1));
        userService.register(user);

        return " User registered Succesfully with role: " +role;

    }

}
