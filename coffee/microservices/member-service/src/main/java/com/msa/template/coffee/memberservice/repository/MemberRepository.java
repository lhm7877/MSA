package com.msa.template.coffee.memberservice.repository;

import com.msa.template.coffee.api.core.member.dto.MemberDto;
import com.msa.template.coffee.memberservice.model.Member;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Repository
public interface MemberRepository extends ReactiveCrudRepository<Member, String> {
    Optional<Mono<Member>> findByUsername(String username);
    
    Mono<Member> findByMemberId(Integer memberId);
}
