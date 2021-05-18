package com.msa.template.coffee.memberservice.controller;

import com.msa.template.coffee.api.core.member.dto.MemberDto;
import com.msa.template.coffee.api.core.member.dto.MemberType;
import com.msa.template.coffee.api.core.member.service.AuthService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.msa.template.coffee.memberservice.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class AuthController implements AuthService {
    
    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    
    @Override
    public Mono<MemberDto> signIn(String id, String password) {
        return null;
    }
    
    @Override
    public Mono<MemberDto> signUp(String username, String name, String contact, String password, MemberType type) {
        return null;
    }
}
