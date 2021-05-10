package com.msa.template.coffee.memberservice.controller;

import com.msa.template.coffee.api.core.member.service.MemberService;
import com.msa.template.coffee.api.core.member.model.Member;
import com.msa.template.coffee.memberservice.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.lang.reflect.Member;

@RestController
@RequiredArgsConstructor
public class MemberController implements MemberService {
    
    private final MemberRepository memberRepository;
    
    @Override
    public Mono<Member> memberById(int memberId) throws Exception {
        if( memberId < 1)
            throw new Exception();
        return memberRepository.findByMemberId(memberId);
    }
}
