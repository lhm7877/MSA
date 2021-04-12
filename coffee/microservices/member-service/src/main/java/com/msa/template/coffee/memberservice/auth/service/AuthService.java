package com.msa.template.coffee.memberservice.auth.service;

import com.msa.template.coffee.memberservice.auth.dto.request.LoginRequest;
import com.msa.template.coffee.memberservice.auth.dto.response.LoginResponse;
import com.msa.template.coffee.memberservice.auth.exception.LoginFailedException;
import com.msa.template.coffee.memberservice.member.model.Member;
import lombok.AllArgsConstructor;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.io.IOException;
import java.nio.file.Files;

@Service
public class AuthService {
    
    private final ResourceLoader resourceLoader;
    
    public AuthService(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }
    
    public Flux<LoginResponse> login(LoginRequest loginRequest) {
        try {
            return Flux.empty();
        } catch (LoginFailedException e) {
            return Flux.empty();
        }
    }
    
}
