package com.msa.template.coffee.order.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class GoodsDto {
    private Long menuSn;
    private Long parentMenuSn;
    private BigDecimal originalPrice;
    private BigDecimal discountPercent;
    private BigDecimal discountedPrice;
    private List<GoodsDto> options = new ArrayList<>();
}
