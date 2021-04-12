package com.msa.template.coffee.memberservice.auth.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LoginResponse {
    
    private final String accessToken;
    private final String refreshToken;
    
}
