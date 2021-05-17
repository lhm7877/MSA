package com.msa.template.coffee.microservices.core.coupon.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Document(collection = "coupon_history")
public class CouponHistoryEntity {

    @Id @Column(name = "coupon_history_id")
    private Long id;

    private String date;

    private Long couponId;

    @Enumerated(EnumType.STRING)
    private CouponStatus couponStatus;

}
