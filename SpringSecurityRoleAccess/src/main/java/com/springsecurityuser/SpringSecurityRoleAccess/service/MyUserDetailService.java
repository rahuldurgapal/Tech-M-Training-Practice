package com.springsecurityuser.SpringSecurityRoleAccess.service;

import com.springsecurityuser.SpringSecurityRoleAccess.model.MyUserDetail;
import com.springsecurityuser.SpringSecurityRoleAccess.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UserService userService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("Before user found");
        User user = userService.getUserByName(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        System.out.println("After User found");

      return new MyUserDetail(user);
    }
}
