package com.msa.template.coffee.payment.controller.rqrs;

import com.msa.template.coffee.payment.enums.PaymentCodeDefinition.PaymentCode;
import com.msa.template.coffee.payment.enums.PaymentCodeDefinition.PaymentType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentRs extends BaseRs{
    PaymentCode paymentCode;

}
