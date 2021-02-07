package com.jinwon.msa.controller.api;

import com.jinwon.msa.controller.api.rqrs.SaveUserRq;
import com.jinwon.msa.service.UserService;
import com.jinwon.msa.streams.SendStream;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Api(tags = "로그인 API 컨트롤러")
@RequestMapping(value = "/login")
public class LoginApiController {

    private UserService userService;

    @PostMapping(value = "/save", produces = "application/json")
    public boolean save(SaveUserRq rq) {
        return userService.save(SaveUserRq.of(rq));
    }

}
