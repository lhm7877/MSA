package com.msa.template.coffee.memberservice.controller;

import com.msa.template.coffee.api.core.member.service.MemberService;
import com.msa.template.coffee.api.core.member.model.Member;
import com.msa.template.coffee.memberservice.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class MemberController implements MemberService {
    
    private final MemberRepository memberRepository;
    
    @Override
    public Mono<Member> memberById(int memberId) {
        if( memberId < 1)
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        return memberRepository.findByMemberId(memberId);
    }
    
    @Override
    public Flux<Member> memberList() {
        return null;
    }
}
