package com.msa.template.coffee.memberservice.auth.service;

import com.msa.template.coffee.memberservice.auth.dto.request.LoginRequest;
import com.msa.template.coffee.memberservice.auth.dto.request.SignupRequest;
import com.msa.template.coffee.memberservice.auth.dto.response.LoginResponse;
import com.msa.template.coffee.memberservice.auth.dto.response.SignupResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import reactor.core.publisher.Mono;

public interface AuthService {
    
    @PostMapping(
            value = "/auth/login",
            produces = "application/json"
    )
    Mono<LoginResponse> login(@PathVariable LoginRequest request);
    
    @PostMapping(
            /* XXX 오타 쟁이 */
            value = "/auth/sigiup",
            produces = "application/json"
    )
    Mono<SignupResponse> signup(@PathVariable SignupRequest request);
    
//    private final ResourceLoader resourceLoader;
    
//    public AuthService(ResourceLoader resourceLoader) {
//        this.resourceLoader = resourceLoader;
//    }
    
//    public Flux<LoginResponse> login(LoginRequest loginRequest) {
//        try {
//            return Flux.empty();
//        } catch (LoginFailedException e) {
//            return Flux.empty();
//        }
//    }
    
}
