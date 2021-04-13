package com.msa.template.coffee.productservice.services;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.msa.template.coffee.api.core.product.ProductVo;
import com.msa.template.coffee.productservice.persistence.ProductEntity;

@Mapper(componentModel = "spring") 	// bean으로 만듦
public interface ProductMapper {

	ProductVo entityToApi(ProductEntity entity);

	@Mappings({
		@Mapping(target = "id", ignore = true),
		@Mapping(target = "version", ignore = true)
	})
	ProductEntity apiToEntity(ProductVo api);
}