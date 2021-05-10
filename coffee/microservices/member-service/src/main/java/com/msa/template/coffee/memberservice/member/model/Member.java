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
/* XXX 요긴 setter 없는데 빈 생성자 만드는 이유는 뭐예용? */
// setter를 사용하지 않고 update 등에 필요한거 명시적으로 set하려고
// 빈생성자는 지양 이유는 찾자
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