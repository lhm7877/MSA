package com.msa.template.coffee.api.core.coupon.dto;

import com.msa.template.coffee.api.core.coupon.enums.CouponStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CouponDto {
    private String couponNumber;
    private String productId;
    private String productName;
    private int productPrice;
    private Long memberId;
    private Date expirationDate;
    private CouponStatus couponStatus;

    @Override
    public String toString() {
        return "CouponDto{" +
                "couponNumber='" + couponNumber + '\'' +
                ", productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", memberId=" + memberId +
                ", expirationDate=" + expirationDate +
                ", couponStatus=" + couponStatus +
                '}';
    }
}
