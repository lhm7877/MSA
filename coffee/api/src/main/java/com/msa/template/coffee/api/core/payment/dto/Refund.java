package com.msa.template.coffee.api.core.payment.dto;

import com.msa.template.coffee.api.core.payment.enums.PaymentCodeDefinition.RefundCode;
import com.msa.template.coffee.api.core.payment.enums.PaymentCodeDefinition.RefundType;

public class Refund {
    private Long memberId;
    private Long refundAmount;
    private RefundType refundType;
    private RefundCode refundCode;
    private String date;
}
