package com.msa.template.coffee.api.core.coupon.dto;

import com.msa.template.coffee.api.core.coupon.enums.CouponStatus;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CouponDto {

    private Long id;

    private String name;

    private String number;

    private int count;

    private int percent;

    private int amount;

    private int minPrice;

    private int limitPrice;

    private Long memberId;

    private CouponStatus couponStatus;
}
