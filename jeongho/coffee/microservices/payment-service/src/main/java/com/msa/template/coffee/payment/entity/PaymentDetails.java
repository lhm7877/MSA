package com.msa.template.coffee.payment.entity;

import com.msa.template.coffee.payment.enums.PaymentCodeDefinition.PaymentCode;
import com.msa.template.coffee.payment.enums.PaymentCodeDefinition.PaymentType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentDetails extends BaseEntity{
    Long paymentSn;
    PaymentType paymentType;
    PaymentCode paymentCode;
}
