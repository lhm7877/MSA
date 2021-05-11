package com.msa.template.coffee.couponservice.service;

import com.msa.template.coffee.api.core.coupon.dto.CouponDto;
import com.msa.template.coffee.api.core.coupon.dto.UseCouponDto;
import com.msa.template.coffee.api.core.coupon.service.CouponService;
import com.msa.template.coffee.couponservice.repository.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class CouponServiceImpl implements CouponService {
    private final CouponRepository couponRepository;
    private final CouponMapper couponMapper;

    @Autowired
    public CouponServiceImpl(CouponRepository couponRepository, CouponMapper couponMapper) {
        this.couponRepository = couponRepository;
        this.couponMapper = couponMapper;
    }

    @Override
    public Flux<CouponDto> getList(int memberId) {
        return null;
    }

    @Override
    public Mono<Boolean> use(UseCouponDto rq) {
        return null;
    }
}
