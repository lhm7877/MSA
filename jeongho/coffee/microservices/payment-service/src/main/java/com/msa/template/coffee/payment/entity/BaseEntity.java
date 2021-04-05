package com.msa.template.coffee.payment.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseEntity {
    Integer memberId;
    Integer price;
    String menu;
}
