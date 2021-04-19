package com.msa.template.coffee.memberservice.service;

import com.msa.template.coffee.memberservice.auth.dto.request.LoginRequest;
import com.msa.template.coffee.memberservice.auth.dto.request.SignupRequest;
import com.msa.template.coffee.memberservice.auth.dto.response.LoginResponse;
import com.msa.template.coffee.memberservice.auth.dto.response.SignupResponse;
import com.msa.template.coffee.memberservice.auth.service.AuthService;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class AuthServiceImpl implements AuthService {
    
    @Override
    public Mono<LoginResponse> login(LoginRequest request) {
        return null;
    }
    
    @Override
    public Mono<SignupResponse> signup(SignupRequest request) {
        return null;
    }
}
