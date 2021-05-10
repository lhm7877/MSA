package com.msa.template.coffee.api.core.coupon.service;

import com.msa.template.coffee.api.core.coupon.dto.CouponDto;
import com.msa.template.coffee.api.core.coupon.dto.UseCouponDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CouponService {

    @GetMapping(
            value    = "/coupon/{memberId}",
            produces = "application/json")
    Flux<CouponDto> getList(@PathVariable int memberId);

    @PostMapping(
            value = "/coupon/use",
            produces = "application/json")
    Mono<Boolean> use(UseCouponDto rq);
}
