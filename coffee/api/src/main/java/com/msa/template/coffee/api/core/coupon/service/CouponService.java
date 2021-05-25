package com.msa.template.coffee.api.core.coupon.service;

import com.msa.template.coffee.api.core.coupon.dto.CouponDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CouponService {

    @PostMapping(
            value = "/coupon",
            consumes = "application/json",
            produces = "application/json"
    )
    Mono<CouponDto> createCoupon(@RequestBody CouponDto couponDto);

    @GetMapping(
            value    = "/coupon/{memberId}",
            produces = "application/json")
    Flux<CouponDto> getList(@PathVariable Long memberId);
}
