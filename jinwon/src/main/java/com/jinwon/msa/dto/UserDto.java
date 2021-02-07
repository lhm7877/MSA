package com.jinwon.msa.dto;

import com.jinwon.msa.entity.UserEntity;
import com.sun.istack.NotNull;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    @NonNull
    private String name;
    @NonNull
    private String account;
    @NonNull
    private String password;

    public UserEntity of(UserDto dto) {

        String account = dto.getAccount();
        return UserEntity.create(dto.name, dto.account, dto.password);
    }
}
