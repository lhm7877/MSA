package com.msa.template.coffee.memberservice.auth.dto.response;

import lombok.Builder;
import lombok.Getter;

/* TODO 토큰??? oauth 로그인 구현하시나용? */
@Getter
@Builder
public class LoginResponse {
    
    private final String accessToken;
    private final String refreshToken;
    
}
