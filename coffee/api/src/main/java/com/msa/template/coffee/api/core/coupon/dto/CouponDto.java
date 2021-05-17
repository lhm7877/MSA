package com.msa.template.coffee.api.core.coupon.dto;

import com.msa.template.coffee.api.core.coupon.enums.CouponStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CouponDto {
    private String couponNumber;
    private String productId;
    private String productName;
    private int productPrice;
    private Long memberId;
    private CouponStatus couponStatus;
}
