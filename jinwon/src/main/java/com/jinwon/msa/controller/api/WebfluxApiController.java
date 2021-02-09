package com.jinwon.msa.controller.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@RestController
@AllArgsConstructor
@Api(tags = "웹 플럭스 API 컨트롤러")
@RequestMapping(value = "/webflux")
public class WebfluxApiController {

    @ApiOperation(value = "쿠키 탈취")
    @GetMapping(value = "/my-cookies", produces = "application/json")
    public Cookie[] getCookies(HttpServletRequest request) {
        return request.getCookies();
    }

}
