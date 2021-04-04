package com.msa.template.coffee.order.controller;

import com.msa.template.coffee.order.controller.rqrs.OrderRq;
import com.msa.template.coffee.order.controller.rqrs.OrderRs;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
public class OrderRestController extends BaseController {

    /**
     * @Codes - E001 : 사용자 조회 불가
     * - E002 : 메뉴 조회 불가
     * - E003 : 결제 타입 조회 불가
     * - E999 : 기타 에러 메세지 참조
     */
    @PostMapping("/order")
    public Mono<OrderRs> order(OrderRq rq) {

        /*
         API member service
         checkMemberSn();
        */

        /*
         API goods service
         getGoodsList();
        */

        /*
         checkOrder();
        */

        /*
         saveOrder();
        */

        /*
         saveHistory();
        */

        OrderRs rs = new OrderRs();

        return Mono.just(rs);
    }

}
