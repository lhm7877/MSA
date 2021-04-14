package com.msa.template.coffee.api.core.order.dto;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class OrderCancelDto {
    @NonNull
    private Long orderSn;
    @NonNull
    private Long memberSn;
    private String cancelReason;
}
