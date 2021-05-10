package com.msa.template.coffee.api.core.order.dto;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class OrderCancelDto {

    @NonNull
    private Long orderId;
    @NonNull
    private Long memberId;
    private String cancelReason;

}
