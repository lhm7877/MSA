package com.msa.template.coffee.payment.controller.rqrs;

import com.msa.template.coffee.payment.enums.PaymentCodeDefinition.PaymentCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentRs extends BaseRs{
    private PaymentCode paymentCode;

}
