package com.msa.template.coffee.payment.entity;

import com.msa.template.coffee.payment.enums.PaymentCodeDefinition.PaymentCode;
import com.msa.template.coffee.payment.enums.PaymentCodeDefinition.PaymentType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "PaymentDetails")
public class PaymentDetails {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "member_id", nullable = false)
    private Long memberId;

    @Column(name = "payment_amount", nullable = false)
    private Long paymentAmount;

    @Column(name = "payment_type", nullable = false)
    private PaymentType paymentType;

    @Column(name = "payment_code", nullable = false)
    private PaymentCode paymentCode;

    @Column(name = "date", nullable = false)
    private String date;
}
