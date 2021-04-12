package com.msa.template.coffee.payment.entity;

import com.msa.template.coffee.payment.enums.PaymentCodeDefinition.RefundCode;
import com.msa.template.coffee.payment.enums.PaymentCodeDefinition.RefundType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RefundDetails  extends BaseEntity{
    Long refundSn;
    RefundType refundType;
    RefundCode refundCode;
}
