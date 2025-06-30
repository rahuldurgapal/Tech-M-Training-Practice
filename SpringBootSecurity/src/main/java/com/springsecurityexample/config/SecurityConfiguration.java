package com.springsecurityexample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception {

//        Customizer<CsrfConfigurer<HttpSecurity>> csrfCustomizer = new Customizer<CsrfConfigurer<HttpSecurity>>() {
//
//            @Override
//            public void customize(CsrfConfigurer<HttpSecurity> httpSecurityCsrfConfigurer) {
//                  httpSecurityCsrfConfigurer.disable();
//            }
//        };

         return //security.csrf(cutomizer -> cutomizer.disable())
                security.authorizeHttpRequests(req ->
                            req.requestMatchers("/admin/*").permitAll())
               .authorizeHttpRequests(req ->
                           req.requestMatchers("/user/*").authenticated())
                 .formLogin(form -> form.loginPage("/mylogin").
                         defaultSuccessUrl(("/home")))
                 .build();
              //  .httpBasic(Customizer.withDefaults()).build();
        //.httpBasic(Customizer.withDefaults()).build();

    }

    @Bean
    public UserDetailsService userDetailsService() {

//        UserDetails user1 = User.withUsername("admin").
//                password("{noop}admin@123")
//                .build();

        UserDetails user1 =
                new User("admin","{noop}admin@123", Collections.singleton(new SimpleGrantedAuthority("ADMIN")));

        UserDetails user2 = User.withUsername("user")
                .password("{noop}user@123").build();


        return new InMemoryUserDetailsManager(user1,user2);
    }



}
