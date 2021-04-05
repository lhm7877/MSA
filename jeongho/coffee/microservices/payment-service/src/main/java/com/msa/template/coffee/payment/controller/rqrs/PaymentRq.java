package com.msa.template.coffee.payment.controller.rqrs;

import com.msa.template.coffee.payment.enums.PaymentCodeDefinition.PaymentType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentRq extends BaseRq{
    PaymentType paymentType;
    Integer price;
    String menu;
}
