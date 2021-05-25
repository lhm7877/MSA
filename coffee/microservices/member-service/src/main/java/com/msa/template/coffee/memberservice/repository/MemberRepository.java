package com.msa.template.coffee.memberservice.repository;

import com.msa.template.coffee.memberservice.model.Member;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface MemberRepository extends ReactiveMongoRepository<Member, String> {
    Mono<Member> findByMemberId(Integer memberId);
}
