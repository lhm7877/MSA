package com.msa.template.coffee.api.core.order.dto;

import com.msa.template.coffee.api.core.order.constant.ResponseType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
// TODO 이후민 : errorMessage를 baseDto에서 사용할 필요가 있을까요? WebExceptionHandler에서 처리하는게 좋아보여요
// TODO 이후민 : responseType은 http status로 대체하는건 어때요?
public abstract class BaseDto {
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
