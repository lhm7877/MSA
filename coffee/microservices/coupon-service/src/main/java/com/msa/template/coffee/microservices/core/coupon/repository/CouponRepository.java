package com.msa.template.coffee.microservices.core.coupon.repository;

import com.msa.template.coffee.microservices.core.coupon.entity.CouponEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;


public interface CouponRepository extends ReactiveCrudRepository<CouponEntity, String> {
    Flux<CouponEntity> findByMemberId(Long memberId);
}
