package com.maharshi.spring.boot.security.jwt.boilerplate.repository;


import com.maharshi.spring.boot.security.jwt.boilerplate.model.OTPVo;
import com.maharshi.spring.boot.security.jwt.boilerplate.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OTPRepository extends CrudRepository<OTPVo,Integer> {

    List<OTPVo> findByUser(User user);
}
