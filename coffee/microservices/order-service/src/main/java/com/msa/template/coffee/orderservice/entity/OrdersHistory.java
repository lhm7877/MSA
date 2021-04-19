package com.msa.template.coffee.orderservice.entity;

import com.msa.template.coffee.api.core.order.enums.PaymentType;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
public class OrdersHistory extends BaseEntity {

    @Id
    private Long id;

    private Long orderId;

    /* 주문 번호에 해당하는 회원은 변경 불가 */
    @Column(nullable = false, updatable = false)
    private Long memberId;

    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;

    @Column(precision = 5, scale = 2)
    private BigDecimal originalPrice;

    @Column(precision = 5, scale = 2)
    private BigDecimal discountPercent;

    @Column(precision = 5, scale = 2)
    private BigDecimal discountedPrice;

    private boolean cancelYn;

    @JoinColumn(name = "orders_history_id")
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<OrderGoods> orderGoods = new ArrayList<>();

    public List<OrderGoods> addOptions(List<OrderGoods> orderGoods) {
        this.orderGoods.addAll(orderGoods);
        return this.orderGoods;
    }

    public List<OrderGoods> removeOptions(List<OrderGoods> orderGoods) {
        this.orderGoods.removeAll(orderGoods);
        return this.orderGoods;
    }

    public static OrdersHistory create(Long orderId, Long memberId, PaymentType paymentType, BigDecimal originalPrice,
                                       BigDecimal discountPercent, BigDecimal discountedPrice, boolean cancelYn,
                                       List<OrderGoods> orderGoods) {
        OrdersHistory ordersHistory = new OrdersHistory();

        ordersHistory.orderId = orderId;
        ordersHistory.memberId = memberId;
        ordersHistory.paymentType = paymentType;
        ordersHistory.originalPrice = originalPrice;
        ordersHistory.discountPercent = discountPercent;
        ordersHistory.discountedPrice = discountedPrice;
        ordersHistory.cancelYn = cancelYn;
        ordersHistory.orderGoods.addAll(orderGoods);

        return ordersHistory;
    }

    // TODO 이후민 : of 메소드명 좋은거같아요 그런데 mapstruct를 사용할 수도 있지 않을까요?
    public static OrdersHistory of(Orders orders) {
        OrdersHistory ordersHistory = new OrdersHistory();

        ordersHistory.orderId = orders.getId();
        ordersHistory.memberId = orders.getMemberId();
        ordersHistory.paymentType = orders.getPaymentType();
        ordersHistory.originalPrice = orders.getOriginalPrice();
        ordersHistory.discountPercent = orders.getDiscountPercent();
        ordersHistory.discountedPrice = orders.getDiscountedPrice();
        ordersHistory.cancelYn = orders.getCancelYn();
        ordersHistory.orderGoods.addAll(orders.getOrderGoods());

        return ordersHistory;
    }

}
