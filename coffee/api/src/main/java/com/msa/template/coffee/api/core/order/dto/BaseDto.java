package com.msa.template.coffee.api.core.order.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.msa.template.coffee.api.core.order.constant.ResponseType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public abstract class BaseDto {
    private HttpStatus responseType;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String errorMessage;

    public void successRs() {
        this.responseType = HttpStatus.OK;
    }

    public void successRs(boolean successYn) {
        if (successYn) {
            this.responseType = HttpStatus.OK;
            return;
        }

        this.responseType = HttpStatus.INTERNAL_SERVER_ERROR;
    }

}
