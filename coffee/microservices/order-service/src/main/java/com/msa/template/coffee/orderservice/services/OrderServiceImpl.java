package com.msa.template.coffee.orderservice.services;

import com.msa.template.coffee.api.core.order.dto.OrderCancelDto;
import com.msa.template.coffee.api.core.order.dto.OrderDto;
import com.msa.template.coffee.api.core.order.dto.OrderLoadDto;
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
import reactor.core.scheduler.Scheduler;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
// TODO 이후민 : ProductCompositerSerivce쪽에도 구현이 필요해 보여요
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
    public Flux<SuccessDto> order(OrderDto orderDto) {
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
        // TODO 이후민 : 이부분은 동기적으로 실행될거같은데 스케쥴러같은 방식을 사용해서 비동기적으로 처리 할 수 있을까요?
        // TODO 이후민 : https://itstory.tk/entry/Spring-Webflux-JDBC%ED%98%B9%EC%9D%80-blocking-call-%ED%95%B8%EB%93%A4%EB%A7%81-%EB%B0%A9%EB%B2%95
        Orders savedOrders = ordersRepository.save(orders);

        /*
         saveHistory();
        */

        ordersHistoryRepository.save(OrdersHistory.of(savedOrders));

        SuccessDto rs = new SuccessDto();

		return Flux.just(rs);
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
    public Flux<OrderLoadDto> getList(int memberId) {
        /*
         API member service
         checkMemberSn();
        */

        List<Orders> orders = ordersRepository.findAllByMemberId(memberId);
        List<OrderLoadDto> orderLoads = orderMapper.apiToEntity(orders);

        return asyncFlux(orderLoads);
    }

    private <T> Flux<T> asyncFlux(Iterable<T> iterable) {
        return Flux.fromIterable(iterable).publishOn(scheduler);
    }

}
