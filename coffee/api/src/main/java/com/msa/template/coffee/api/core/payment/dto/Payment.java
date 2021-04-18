package com.msa.template.coffee.api.core.payment.dto;

import com.msa.template.coffee.api.core.payment.enums.PaymentCodeDefinition.PaymentCode;
import com.msa.template.coffee.api.core.payment.enums.PaymentCodeDefinition.PaymentType;

public class Payment {
    private Long memberId;
    private Long paymentAmount;
    private PaymentType paymentType;
    private PaymentCode paymentCode;
    private String date;
}
