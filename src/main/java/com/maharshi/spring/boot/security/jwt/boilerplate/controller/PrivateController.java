package com.maharshi.spring.boot.security.jwt.boilerplate.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/private")
public class PrivateController {

    @GetMapping("/getUsers")
    public String getUsers() {
        return "you got the users";
    }

    @GetMapping("/getMe")
    public ResponseEntity<String> getMe() {
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        String username=authentication.getName();
        System.out.println("Request Reached");
        return new ResponseEntity<>(username, HttpStatus.OK);
    }
}
