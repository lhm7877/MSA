package com.msa.template.coffee.payment.entity;

import com.msa.template.coffee.payment.enums.PaymentCodeDefinition.RefundCode;
import com.msa.template.coffee.payment.enums.PaymentCodeDefinition.RefundType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class RefundDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "member_id", nullable = false)
    private Long memberId;

    @Column(name = "refund_amount", nullable = false)
    private Long refundAmount;

    @Column(name = "refund_type", nullable = false)
    private RefundType refundType;

    @Column(name = "refund_code", nullable = false)
    private RefundCode refundCode;

    @Column(name = "date", nullable = false)
    private String date;
}
