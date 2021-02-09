package com.jinwon.msa.controller.api.rqrs;

import com.jinwon.msa.dto.UserDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Getter
@Setter
public class SaveUserRq {
    @NonNull
    @ApiModelProperty(value = "이름", required = true)
    private String name;
    @NonNull
    @ApiModelProperty(value = "계정", required = true)
    private String account;
    @NonNull
    @ApiModelProperty(value = "패스워드", required = true)
    private String password;

    public static UserDto of(SaveUserRq rq){
        UserDto dto = new UserDto();
        dto.setName(rq.getName());
        dto.setAccount(rq.getAccount());
        dto.setPassword(rq.getPassword());
        return dto;
    }

    public void setPassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        this.password = encoder.encode(password);
    }
}
