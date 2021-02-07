package com.jinwon.msa.controller.view;

import com.jinwon.msa.controller.api.rqrs.SaveUserRq;
import com.jinwon.msa.service.UserService;
import com.jinwon.msa.streams.SendStream;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Api(tags = "로그인 화면 컨트롤러")
@AllArgsConstructor
@Controller
public class LoginController {

    private SendStream sendStream;


    @GetMapping(value = "/login")
    public String getLoginPage() {
        sendStream.send("zzzzzzzzzzzzzzzzzzzz");
        return "/login";
    }

    @GetMapping(value = "/sign-up")
    public String getSignUpPadge() {
        return "/signup";
    }

}
