package com.msa.template.coffee.api.core.order.dto;

import com.msa.template.coffee.api.core.order.dto.GoodsDto;
import com.msa.template.coffee.api.core.order.enums.PaymentType;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class OrderDto {
    @NonNull
    private Long memberId;
    @NonNull
    private PaymentType paymentType;
    private BigDecimal originalPrice;
    private BigDecimal discountPercent;
    private BigDecimal discountedPrice;
    private boolean cancelYn;
    @NonNull
    private List<GoodsDto> orderGoods = new ArrayList<>();
}
