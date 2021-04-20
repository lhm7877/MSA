package com.msa.template.coffee.api.core.order.dto;

import com.msa.template.coffee.api.core.order.constant.ResponseType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
// XXX 이후민 : errorMessage를 baseDto에서 사용할 필요가 있을까요? WebExceptionHandler에서 처리하는게 좋아보여요
// XXX 이진원 : errorMessage는 기본적으로 있는게 좋아보이더라구요. 개발을 하면서 느꼈어요 상대 서비스에서 정형화하여 잡아낼 수가 있어서 좋은거 같아요. WebExceptionHandler 요 방식은 어떻게 하는지 찾아보는게 좋을 거 같네요.

// XXX 이후민 : responseType은 http status로 대체하는건 어때요?
// XXX 이진원 : 임시로 만들어놨어요ㅋㅋㅋㅋ 좋은거 같네요
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
