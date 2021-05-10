package com.msa.template.coffee.couponservice.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Document(collection = "coupon")
public class CouponEntity {

    @Id @Column(name = "coupon_id")
    private Long id;

    private String name;

    private String number;

    private int count;

    private int percent;

    private int amount;

    private int minPrice;

    private int limitPrice;

    private Long memberId;

    @Enumerated(EnumType.STRING)
    private CouponStatus couponStatus;
}
