package com.msa.template.coffee.microservices.core.product.services;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.msa.template.coffee.api.core.product.ProductDto;
import com.msa.template.coffee.microservices.core.product.persistence.ProductEntity;

//XXX:
// dto <-> entity 간에 필드명이 다르지만 매핑시키고자 할때는 어떤씩으로 사용하는지.
// 예를들어 dto.companySn <-> entity.companySubjectSn
// 이후민 : https://www.javaer101.com/article/1474113.html
@Mapper(componentModel = "spring") 	// bean으로 만듦
public interface ProductMapper {

	ProductDto entityToApi(ProductEntity entity);

	@Mappings({
		@Mapping(target = "id", ignore = true),
		@Mapping(target = "version", ignore = true)
	})
	ProductEntity apiToEntity(ProductDto api);
}
