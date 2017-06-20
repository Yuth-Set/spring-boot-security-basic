package com.example.security.springbootsecurity.resources;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * Created by SET Yuth on 6/20/2017.
 */
@RestController
@RequestMapping("/rest/hello")
public class HelloResource {
    @GetMapping
    public String hello(@AuthenticationPrincipal final UserDetails userDetails) {
        String username = userDetails.getUsername();
        Collection<?extends GrantedAuthority> authorities = userDetails.getAuthorities();
        authorities
                .forEach(System.out::println);
        return "Hello WebSecurity";
    }
}
