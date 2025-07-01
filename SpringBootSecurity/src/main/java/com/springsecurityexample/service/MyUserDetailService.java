package com.springsecurityexample.service;

import com.springsecurityexample.model.MyUserDetail;
import com.springsecurityexample.model.User;
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
        User user = userService.getUserByName(username);

        if(user==null) {
            System.out.println("User not found");
            throw new UsernameNotFoundException("User not found");
        }
        return new MyUserDetail(user);
    }
}
