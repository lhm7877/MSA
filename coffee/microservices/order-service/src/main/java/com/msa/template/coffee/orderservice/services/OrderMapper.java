package com.msa.template.coffee.orderservice.services;

import com.msa.template.coffee.api.core.order.dto.OrderDto;
import com.msa.template.coffee.api.core.order.dto.OrderLoadDto;
import com.msa.template.coffee.orderservice.entity.OrdersEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {

	OrderDto entityToApi(OrdersEntity ordersEntity);

	@Mappings({
		@Mapping(target = "id", ignore = true)
	})
	OrdersEntity apiToEntity(OrderDto api);

	@Mappings({})
	List<OrderLoadDto> apiToEntity(List<OrdersEntity> api);


}
