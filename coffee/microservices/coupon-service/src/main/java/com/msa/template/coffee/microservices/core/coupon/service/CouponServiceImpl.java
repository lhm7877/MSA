package com.msa.template.coffee.microservices.core.coupon.service;

import com.msa.template.coffee.api.core.coupon.dto.CouponDto;
import com.msa.template.coffee.api.core.coupon.service.CouponService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class CouponServiceImpl implements CouponService {
    @Override
    public Flux<CouponDto> getList(int memberId) {
        return null;
    }

    @Override
    public Mono<Boolean> use(CouponDto rq) {
        return null;
    }
}
