package com.maharshi.spring.boot.security.jwt.boilerplate.service;


import com.maharshi.spring.boot.security.jwt.boilerplate.model.User;
import com.maharshi.spring.boot.security.jwt.boilerplate.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserServiceImp implements UserService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public void insertUser(User user) {
    userRepository.save(user);
  }

  @Override
  public User findByUserName(String username) {
    return this.userRepository.findByUsername(username).get(0);
  }

}
