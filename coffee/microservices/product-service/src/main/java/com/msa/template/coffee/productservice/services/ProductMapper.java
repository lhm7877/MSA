package com.msa.template.coffee.productservice.services;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.msa.template.coffee.api.core.product.ProductVo;
import com.msa.template.coffee.productservice.persistence.ProductEntity;

//TODO:
// dto <-> entity 간에 필드명이 다르지만 매핑시키고자 할때는 어떤씩으로 사용하는지.
// 예를들어 dto.companySn <-> entity.companySubjectSn

@Mapper(componentModel = "spring") 	// bean으로 만듦
public interface ProductMapper {

	ProductVo entityToApi(ProductEntity entity);

	@Mappings({
		@Mapping(target = "id", ignore = true),
		@Mapping(target = "version", ignore = true)
	})
	ProductEntity apiToEntity(ProductVo api);
}
