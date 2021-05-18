package com.msa.template.coffee.memberservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "invalid parameter.")
public class InvalidParameterException extends RuntimeException {
}
