package com.maharshi.spring.boot.security.jwt.boilerplate.service;

import com.maharshi.spring.boot.security.jwt.boilerplate.model.User;

public interface UserService {

  void insertUser(User user);

  User findByUserName(String username);
}
