package com.msa.template.coffee.microservice.core.order.services;

import com.msa.template.coffee.api.core.order.dto.OrderDto;
import com.msa.template.coffee.api.core.order.dto.OrderLoadDto;
import com.msa.template.coffee.microservice.core.order.entity.OrdersEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface OrderMapper {

	OrderDto entityToApi(OrdersEntity ordersEntity);

	@Mappings({
//		@Mapping(target = "Id", ignore = true)
	})
	OrdersEntity apiToEntity(OrderDto api);

	@Mappings({})
	OrderLoadDto apiToEntity(OrdersEntity api);


}
