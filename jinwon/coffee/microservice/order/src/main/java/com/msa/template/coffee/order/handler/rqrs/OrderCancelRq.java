package com.msa.template.coffee.order.handler.rqrs;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class OrderCancelRq {
    @NonNull
    private Long orderSn;
    @NonNull
    private Long memberSn;
    private String cancelReason;
}
