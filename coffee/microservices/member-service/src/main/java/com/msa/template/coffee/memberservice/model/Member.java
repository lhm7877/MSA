package com.msa.template.coffee.memberservice.model;

import com.msa.template.coffee.api.core.member.dto.MemberType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Document
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Member {
    @Id
    @GeneratedValue
    private String id;
    
    private String username;
    
    private String name;
    
    private String part;
    
    private String contact;
    
    private String encryptedPassword;
    
    @Enumerated
    private MemberType type;
    
    private LocalDateTime createdAt;
    
    private LocalDateTime deletedAt;
}

