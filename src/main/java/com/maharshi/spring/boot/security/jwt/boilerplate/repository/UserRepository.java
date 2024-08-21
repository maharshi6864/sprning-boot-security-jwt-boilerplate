package com.maharshi.spring.boot.security.jwt.boilerplate.repository;

import com.maharshi.spring.boot.security.jwt.boilerplate.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {
  List<User> findByUsername(String username);
}
