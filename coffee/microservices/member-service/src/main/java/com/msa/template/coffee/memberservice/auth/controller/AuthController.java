package com.msa.template.coffee.memberservice.auth.controller;

import com.msa.template.coffee.memberservice.auth.dto.request.LoginRequest;
import com.msa.template.coffee.memberservice.auth.dto.response.LoginResponse;
import com.msa.template.coffee.memberservice.auth.exception.LoginFailedException;
import com.msa.template.coffee.memberservice.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    
    private final AuthService authService;
    
    @PostMapping("/login")
    @ResponseBody
    public Mono<ResponseEntity<LoginResponse>> login(@PathVariable LoginRequest request) {
        return authService.login(request)
                .map(resource -> {
                    try {
                        return ResponseEntity.ok()
                                .contentLength(resource.getAccessToken().length())
                                .body(new InputStreamResource(
                                        resource.getInputStream()
                                ));
                    } catch (LoginFailedException e) {
                        return ResponseEntity.badRequest()
                                .body("Login failed");
                    }
                });
    }
    
}
