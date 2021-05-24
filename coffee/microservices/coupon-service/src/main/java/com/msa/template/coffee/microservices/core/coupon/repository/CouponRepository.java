package com.msa.template.coffee.microservices.core.coupon.repository;

import com.msa.template.coffee.microservices.core.coupon.entity.CouponEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CouponRepository extends CrudRepository<CouponEntity, String> {
    List<CouponEntity> findByMemberId(Long memberId);
}
