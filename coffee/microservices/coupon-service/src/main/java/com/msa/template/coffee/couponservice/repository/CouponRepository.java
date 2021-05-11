package com.msa.template.coffee.couponservice.repository;

import com.msa.template.coffee.couponservice.entity.CouponEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CouponRepository extends ReactiveCrudRepository<CouponEntity, String> {
    Mono<CouponEntity> findByCouponId(int couponId);
    Flux<CouponEntity> findByMemberId(String memberId);
}
