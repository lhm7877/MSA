package com.msa.template.coffee.memberservice.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.lang.reflect.Member;

@Repository
public interface MemberRepository extends ReactiveCrudRepository<Member, String> {
    Mono<Member> findByMemberId(int memberId);
}
