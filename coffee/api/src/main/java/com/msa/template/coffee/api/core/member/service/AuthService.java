package com.msa.template.coffee.api.core.member.service;

import com.msa.template.coffee.api.core.member.dto.MemberDto;
import com.msa.template.coffee.api.core.member.dto.MemberType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import reactor.core.publisher.Mono;

public interface AuthService {
    @PostMapping(
            value = "/signin",
            produces = "application/json")
    Mono<MemberDto> signIn(
            @RequestParam(value = "id") String id,
            @RequestParam(value = "password") String password
    );
    
    @PostMapping(
            value = "/signin",
            produces = "application/json")
    Mono<MemberDto> signUp(
            @RequestParam(value = "username") String username,
            @RequestParam(value = "name") String name,
            @RequestParam(value = "contact") String contact,
            @RequestParam(value = "password") String password,
            @RequestParam(value = "type") MemberType type
    );
    
}
