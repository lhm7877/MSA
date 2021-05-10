package com.msa.template.coffee.api.core.member.service;

import com.msa.template.coffee.api.core.member.model.Member;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MemberService {
    
    @PostMapping(
            value = "/member/{memberId}",
            produces = "application/json")
    Mono<Member> memberById();
    
    @PostMapping(
            value = "/members",
            produces = "application/json")
    Flux<Member> memberList();
    
}
