package com.maharshi.spring.boot.security.jwt.boilerplate.service;



import com.maharshi.spring.boot.security.jwt.boilerplate.model.OTPVo;
import com.maharshi.spring.boot.security.jwt.boilerplate.model.User;

import java.util.Map;

public interface OTPService {

    Map<?, ?> sendOtpForRegistration(User user);

    Map<?, ?> resendOtpForRegistration(User user);

    String getOtpExpriration(String username);

    Map<?, ?> validateOtpForRegistration(OTPVo otpVo);
}
