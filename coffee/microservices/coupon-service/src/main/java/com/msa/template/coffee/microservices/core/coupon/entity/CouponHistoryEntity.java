package com.msa.template.coffee.microservices.core.coupon.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Version;

@Document(collection = "coupon_history")
public class CouponHistoryEntity {

    @Id
    private Long id;

    @Version
    private Integer version;

    private Long couponId;
    private String date;

    @Enumerated(EnumType.STRING)
    private CouponStatus couponStatus;

}
