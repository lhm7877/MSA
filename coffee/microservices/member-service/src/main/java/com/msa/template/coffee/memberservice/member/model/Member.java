package com.msa.template.coffee.memberservice.member.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Getter
@Document
/* TODO 요긴 setter 없는데 빈 생성자 만드는 이유는 뭐예용? */
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    
    @Id
    private String id;
    
    private String username;
    
    private String name;
    
    private String contact;
    
    private String encryptedPassword;
    
    private MemberType type;
    
    private LocalDateTime cratedAt;
    
    private LocalDateTime deletedAt;
    
}