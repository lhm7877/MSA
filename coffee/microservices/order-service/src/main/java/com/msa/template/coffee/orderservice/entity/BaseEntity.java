package com.msa.template.coffee.orderservice.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity {
    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;
}
