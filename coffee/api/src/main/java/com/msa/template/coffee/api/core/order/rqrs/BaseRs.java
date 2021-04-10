package com.msa.template.coffee.api.core.order.rqrs;

import com.msa.template.coffee.api.core.order.constant.ResponseType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class BaseRs {
    private ResponseType responseType;
    private String errorMessage;

    public void successRs() {
        this.responseType = ResponseType.S200;
    }

    public void failRs(ResponseType responseType, String errorMessage) {
        this.responseType = responseType;
        this.errorMessage = errorMessage;
    }

}