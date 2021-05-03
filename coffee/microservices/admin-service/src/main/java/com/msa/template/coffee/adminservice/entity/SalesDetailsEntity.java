package com.msa.template.coffee.adminservice.entity;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Getter
public class SalesDetailsEntity extends SalesEntity{

    @Column(nullable = false)
    private String menu;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private Integer price;
}
