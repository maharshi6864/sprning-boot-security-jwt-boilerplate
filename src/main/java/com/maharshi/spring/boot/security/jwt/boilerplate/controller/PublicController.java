package com.maharshi.spring.boot.security.jwt.boilerplate.controller;

import com.maharshi.spring.boot.security.jwt.boilerplate.model.User;
import com.maharshi.spring.boot.security.jwt.boilerplate.service.UserDetailsServiceImp;
import com.maharshi.spring.boot.security.jwt.boilerplate.service.UserService;
import com.maharshi.spring.boot.security.jwt.boilerplate.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
public class PublicController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImp userDetailsServiceImp;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.insertUser(user);
        return "registered successfully";
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        try {
            this.authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
            String username = this.userDetailsServiceImp.loadUserByUsername(user.getUsername()).getUsername();
            String jwt = jwtUtil.generateToken(username);
            return new ResponseEntity<>(jwt, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Username or password invalid.", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/home")
    public String user() {
        return "user is maharshi";
    }

    @PostMapping("/find")
    public String find(@RequestBody User user) {
        System.out.println("Reached till controller !!");
        return this.userService.findByUserName(user.getUsername()).getUsername();
    }

}
