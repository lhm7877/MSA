package com.msa.template.coffee.microservices.core.coupon.repository;

import com.msa.template.coffee.microservices.core.coupon.entity.CouponEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CouponRepository extends ReactiveMongoRepository<CouponEntity, String> {
    Mono<CouponEntity> findByCouponId(int couponId);
    Flux<CouponEntity> findByMemberId(Long memberId);
}
