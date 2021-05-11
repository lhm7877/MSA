package com.msa.template.coffee.couponservice.service;

import com.msa.template.coffee.couponservice.repository.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CouponServiceImpl {
    private final CouponRepository couponRepository;
    private final CouponMapper couponMapper;

    @Autowired
    public CouponServiceImpl(CouponRepository couponRepository, CouponMapper couponMapper) {
        this.couponRepository = couponRepository;
        this.couponMapper = couponMapper;
    }
}
