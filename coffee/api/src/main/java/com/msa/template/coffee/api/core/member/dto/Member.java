package com.msa.template.coffee.api.core.member.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Member {
    private String id;
    private String username;
    private String name;
    private String contact;
    private String encryptedPassword;
    private MemberType type;
    private LocalDateTime cratedAt;
    private LocalDateTime deletedAt;
}
