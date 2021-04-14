package com.msa.template.coffee.orderservice.services;

import com.msa.template.coffee.api.core.order.dto.OrderCancelDto;
import com.msa.template.coffee.api.core.order.dto.OrderDto;
import com.msa.template.coffee.api.core.order.dto.OrderListDto;
import com.msa.template.coffee.api.core.order.dto.SuccessDto;
import com.msa.template.coffee.api.core.order.service.OrderService;
import com.msa.template.coffee.orderservice.entity.Orders;
import com.msa.template.coffee.orderservice.entity.OrdersHistory;
import com.msa.template.coffee.orderservice.repository.OrdersHistoryRepository;
import com.msa.template.coffee.orderservice.repository.OrdersRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;

import java.util.Optional;

@Slf4j
@RestController
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrdersRepository ordersRepository;
    private final OrdersHistoryRepository ordersHistoryRepository;
    
    private final Scheduler scheduler;
    private final OrderMapper orderMapper;

    /**
     * @Codes - E001 : 사용자 조회 불가
     * - E002 : 메뉴 조회 불가
     * - E003 : 결제 타입 조회 불가
     * - E999 : 기타 에러 메세지 참조
     */
    @Override
    public Mono<SuccessDto> order(OrderDto orderDto) {
    	/*
         API member service
         checkMemberSn();
        */


        /*
         API goods service
        */

        /*
         checkOrder();
        */

        /*
         saveOrder();
        */

        Orders orders = orderMapper.apiToEntity(orderDto);
        Orders savedOrders = ordersRepository.save(orders);

        /*
         saveHistory();
        */

        ordersHistoryRepository.save(OrdersHistory.of(savedOrders));

        SuccessDto rs = new SuccessDto();

		return Mono.just(rs);
    }

    @Override
    public Flux<SuccessDto> cancel(OrderCancelDto orderCancelDto) {

        /*
         API member service
         checkMemberSn();
        */

        /*
         checkOrder()
        */

        /*
         cancelOrder()
        */
        Orders orders = ordersRepository.findByIdAndMemberId(orderCancelDto.getOrderSn(), orderCancelDto.getMemberSn())
                .orElseThrow();

        orders.cancelOrder(orderCancelDto.getCancelReason());

        /*
         saveOrderHistory()
        */

        ordersHistoryRepository.save(OrdersHistory.of(orders));

		SuccessDto rs = new SuccessDto();

		return Flux.just(rs);
    }

    @Override
    public Mono<OrderListDto> getList(int memberId) {
        /*
         API member service
         checkMemberSn();
        */

        return ordersRepository.findAllByMemberId(memberId);
    }

    private <T> Flux<T> asyncFlux(Iterable<T> iterable) {
        return Flux.fromIterable(iterable).publishOn(scheduler);
    }

}
