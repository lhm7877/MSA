package com.msa.template.coffee.memberservice.auth.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.FORBIDDEN, reason = "login failed.")
public class LoginFailedException extends RuntimeException {
}
