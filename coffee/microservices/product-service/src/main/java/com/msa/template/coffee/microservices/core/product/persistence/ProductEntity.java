package com.msa.template.coffee.microservices.core.product.persistence;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document(collation = "product")
@Getter @Setter
public class ProductEntity {

	@Id
	private String id;
	@Version
	private Integer version;
	@Indexed(unique = true)
	private int productId;
	private String name;
	private BigDecimal price;
	private String content;
}
