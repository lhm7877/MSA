package com.msa.template.coffee.api.core.order.dto;

import com.msa.template.coffee.api.core.order.enums.PaymentType;
import lombok.Getter;
import lombok.Setter;


import java.math.BigDecimal;

@Getter
@Setter
public class OrderLoadDto {

    private Long id;
    private Long memberId;
    private PaymentType paymentType;
    private BigDecimal originalPrice;
    private BigDecimal discountPercent;
    private BigDecimal discountedPrice;
    private boolean cancelYn;
    private String cancelReason;

}
