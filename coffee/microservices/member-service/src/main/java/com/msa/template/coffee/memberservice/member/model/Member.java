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