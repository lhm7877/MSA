package com.msa.template.coffee.microservices.core.product.persistence;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Getter;
import lombok.Setter;

@Table("product")
@Getter @Setter
public class ProductEntity {

	@Id
	private int productId;
	private String name;
	private BigDecimal price;
	private String content;
}
