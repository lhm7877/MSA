package com.msa.template.coffee.orderservice.services;

import com.msa.template.coffee.api.core.order.dto.OrderDto;
import com.msa.template.coffee.api.core.order.dto.OrderLoadDto;
import com.msa.template.coffee.orderservice.entity.Orders;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {

	OrderDto entityToApi(Orders orders);

	@Mappings({
		@Mapping(target = "id", ignore = true)
	})
	Orders apiToEntity(OrderDto api);

	@Mappings({})
	List<OrderLoadDto> apiToEntity(List<Orders> api);


}
