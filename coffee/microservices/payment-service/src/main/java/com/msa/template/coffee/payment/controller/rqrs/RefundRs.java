package com.msa.template.coffee.payment.controller.rqrs;

import com.msa.template.coffee.payment.enums.PaymentCodeDefinition.RefundCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RefundRs extends BaseRs{
    RefundCode refundCode;
}
