package com.msa.template.coffee.api.core.order.dto;

public class SuccessDto extends BaseDto {
    public SuccessDto() {
        successRs();
    }

    public SuccessDto(boolean successYn) {
        successRs(successYn);
    }

}
