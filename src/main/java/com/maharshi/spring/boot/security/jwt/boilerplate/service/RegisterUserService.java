package com.maharshi.spring.boot.security.jwt.boilerplate.service;



import com.maharshi.spring.boot.security.jwt.boilerplate.dto.Response;
import com.maharshi.spring.boot.security.jwt.boilerplate.model.User;

import java.util.Map;

public interface RegisterUserService {

    Response registerUser(User user);

    Response checkUsernameAvailable(String username);

    Response confirmUserForRegistration(String username);

    Response resendOtp(User user);

    Response validateOtp(Map<?,?> requestObj);
}
