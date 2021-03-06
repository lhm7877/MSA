package com.msa.template.coffee.api.core.member.service;

import com.msa.template.coffee.api.core.member.dto.MemberDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MemberService {
    
    @PostMapping(
            value = "/member",
            produces = "application/json")
    Mono<MemberDto> memberById(@RequestParam(value = "memberId") int memberId);
    
    @GetMapping(
            value = "/members",
            produces = "application/json")
    Flux<MemberDto> memberList();
    
}
