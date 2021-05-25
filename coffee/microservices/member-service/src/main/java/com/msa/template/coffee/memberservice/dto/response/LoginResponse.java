package com.msa.template.coffee.memberservice.dto.response;

import lombok.Builder;
import lombok.Getter;

/* XXX 토큰??? oauth 로그인 구현하시나용? */
@Getter
@Builder
public class LoginResponse {
    
    private final String accessToken;
    private final String refreshToken;
    
}
