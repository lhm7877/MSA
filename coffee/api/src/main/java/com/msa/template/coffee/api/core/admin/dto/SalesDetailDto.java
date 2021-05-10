package com.msa.template.coffee.api.core.admin.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SalesDetailDto {
    private String startDate;
    private String endDate;
    private Long memberId;
}
