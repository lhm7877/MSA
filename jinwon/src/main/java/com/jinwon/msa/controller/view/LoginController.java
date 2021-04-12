package com.jinwon.msa.controller.view;

import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Api(tags = "로그인 화면 컨트롤러")
@AllArgsConstructor
@Controller
public class LoginController {

    @GetMapping(value = "/login")
    public String getLoginPage() {
        return "/login";
    }

    @GetMapping(value = "/sign-up")
    public String getSignUpPadge() {
        return "/signup";
    }

}
