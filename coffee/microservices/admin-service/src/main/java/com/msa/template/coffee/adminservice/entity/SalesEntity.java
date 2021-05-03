package com.msa.template.coffee.adminservice.entity;

import com.msa.template.coffee.adminservice.enums.CodeDefinitions.StatusCode;
import com.msa.template.coffee.adminservice.enums.CodeDefinitions.PaymentType;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
public class SalesEntity {

    @Id
    private Long salesId;

    @Column(nullable = false)
    private String date;

    @Column(nullable = false, updatable = false)
    private Long memberId;

    @Column(nullable = false)
    private Long totalPrice;

    @Column(nullable = false)
    private StatusCode statusCode;

    @Column(nullable = false)
    private PaymentType paymentType;

}
