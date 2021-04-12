package com.jinwon.msa.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class UserEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 255, nullable = false)
    private String name;

    @Column(length = 255, nullable = false, unique = true)
    private String account;

    @Column(length = 255, nullable = false)
    private String password;

    public String getAccount() {
        return account;
    }

    public String getUniquePass() {
        return password;
    }

    public static UserEntity create(String name, String account, String password) {
        UserEntity userEntity = new UserEntity();
        userEntity.name = name;
        userEntity.account = account;
        userEntity.password = password;
        return userEntity;
    }
}
