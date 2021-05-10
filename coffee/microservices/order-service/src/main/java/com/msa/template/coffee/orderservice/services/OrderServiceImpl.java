package com.msa.template.coffee.orderservice.services;

import com.msa.template.coffee.api.core.order.dto.OrderCancelDto;
import com.msa.template.coffee.api.core.order.dto.OrderDto;
import com.msa.template.coffee.api.core.order.dto.OrderLoadDto;
import com.msa.template.coffee.api.core.order.dto.SuccessDto;
import com.msa.template.coffee.api.core.order.service.OrderService;
import com.msa.template.coffee.orderservice.entity.OrdersEntity;
import com.msa.template.coffee.orderservice.entity.OrdersHistoryEntity;
import com.msa.template.coffee.orderservice.repository.OrdersHistoryRepository;
import com.msa.template.coffee.orderservice.repository.OrdersRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;

import java.util.ArrayList;
import java.util.List;

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
     * @return
     */
    @Override
    public Mono<SuccessDto> order(OrderDto orderDto) {
        OrdersEntity ordersEntity = orderMapper.apiToEntity(orderDto);

        return saveOrders(ordersEntity)
                .any(this::saveOrdersHistory)
                .map(SuccessDto::new)
                .subscribeOn(scheduler);
    }

    /* 주문 저장 */
    private Flux<OrdersEntity> saveOrders(OrdersEntity ordersEntity) {
        return Flux.just(ordersRepository.save(ordersEntity))
                .subscribeOn(scheduler);
    }

    /* 주문 히스토리 저장 */
    private boolean saveOrdersHistory(OrdersEntity order) {
        final OrdersHistoryEntity save = ordersHistoryRepository.save(OrdersHistoryEntity.of(order));
        return ordersHistoryRepository.existsById(save.getId());
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
        OrdersEntity ordersEntity =
                ordersRepository.findByIdAndMemberId(orderCancelDto.getOrderId(), orderCancelDto.getMemberId())
                        .orElseGet(com.msa.template.coffee.orderservice.entity.OrdersEntity::new);

        ordersEntity.cancelOrder(orderCancelDto.getCancelReason());

        /*
         saveOrderHistory()
        */

        ordersHistoryRepository.save(OrdersHistoryEntity.of(ordersEntity));

        SuccessDto rs = new SuccessDto();

        return Flux.just(rs);
    }

    @Override
    public Flux<OrderLoadDto> getList(int memberId) {
        /*
         API member service
         checkMemberSn();
        */

        List<OrdersEntity> orders = ordersRepository.findAllByMemberId(memberId);

        List<OrderLoadDto> orderLoads = new ArrayList<>();

        for (OrdersEntity order : orders) {
            orderLoads.add(orderMapper.apiToEntity(order));
        }

        return asyncFlux(orderLoads);
    }

    private <T> Flux<T> asyncFlux(Iterable<T> iterable) {
        return Flux.fromIterable(iterable).publishOn(scheduler);
    }

}
