package com.maharshi.spring.boot.security.jwt.boilerplate.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stickyNote")
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
public class PrivateController {



}
