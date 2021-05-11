package com.msa.template.coffee.memberservice.repository;

import com.msa.template.coffee.api.core.member.model.Member;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface MemberRepository extends ReactiveCrudRepository<Member, String> {
    Mono<Member> findByMemberId(Mono<Integer> memberId);
}
