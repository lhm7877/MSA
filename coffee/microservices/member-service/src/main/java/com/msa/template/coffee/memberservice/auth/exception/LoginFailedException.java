package com.msa.template.coffee.memberservice.auth.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/* @ExceptionHandler와 @ResponseStatus 요거 차이점은 뭐예요? */

@ResponseStatus(code = HttpStatus.FORBIDDEN, reason = "login failed.")
public class LoginFailedException extends RuntimeException {
}
