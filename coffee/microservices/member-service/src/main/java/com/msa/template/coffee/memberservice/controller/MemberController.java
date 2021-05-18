package com.msa.template.coffee.memberservice.controller;

import com.msa.template.coffee.api.core.member.service.MemberService;
import com.msa.template.coffee.api.core.member.dto.MemberDto;
import com.msa.template.coffee.memberservice.exception.InvalidParameterException;
import com.msa.template.coffee.memberservice.repository.MemberMapper;
import com.msa.template.coffee.memberservice.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class MemberController implements MemberService {
    
    private final MemberRepository memberRepository;
    private final MemberMapper mapper;
    
    @Override
    public Mono<MemberDto> memberById(int memberId) {
        if( memberId < 1) throw new InvalidParameterException();
        return memberRepository.findByMemberId(memberId)
                .map(mapper::entityToApi);
    }
    
    @Override
    public Flux<MemberDto> memberList() {
        return memberRepository.findAll()
                .map(mapper::entityToApi);
    }
}
