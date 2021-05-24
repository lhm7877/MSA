package com.msa.template.coffee.api.core.coupon.service;

import com.msa.template.coffee.api.core.coupon.dto.CouponDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface CouponService {

    @PostMapping(
            value = "/coupon",
            consumes = "application/json",
            produces = "application/json"
    )
    CouponDto createCoupon(@RequestBody CouponDto couponDto);

    @GetMapping(
            value    = "/coupon/{memberId}",
            produces = "application/json")
    List<CouponDto> getList(@PathVariable Long memberId);
}
