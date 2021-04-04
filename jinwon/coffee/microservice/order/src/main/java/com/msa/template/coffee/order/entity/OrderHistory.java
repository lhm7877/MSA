package com.msa.template.coffee.order.entity;

import com.msa.template.coffee.order.enums.PaymentType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
public class OrderHistory extends BaseEntity {

    @Id
    private Long id;

    private Long OrderSn;

    /* 주문 번호에 해당하는 회원은 변경 불가 */
    @Column(nullable = false, updatable = false)
    private Long memberSn;

    private PaymentType paymentType;

    @Column(precision = 5, scale = 2)
    private BigDecimal originalPrice;

    @Column(precision = 5, scale = 2)
    private BigDecimal discountPercent;

    @Column(precision = 5, scale = 2)
    private BigDecimal discountedPrice;

    private boolean cancelYn;

    @OneToMany
    private final List<OrderGoods> orderGoods = new ArrayList<>();

    public List<OrderGoods> addOptions(List<OrderGoods> orderGoods) {
        this.orderGoods.addAll(orderGoods);
        return this.orderGoods;
    }

    public List<OrderGoods> removeOptions(List<OrderGoods> orderGoods) {
        this.orderGoods.removeAll(orderGoods);
        return this.orderGoods;
    }

    public static OrderHistory create(Order order) {
        OrderHistory orderHistory = new OrderHistory();

        orderHistory.OrderSn = order.getId();
        orderHistory.memberSn = order.getMemberSn();
        orderHistory.paymentType = order.getPaymentType();
        orderHistory.originalPrice = order.getOriginalPrice();
        orderHistory.discountPercent = order.getDiscountPercent();
        orderHistory.discountedPrice = order.getDiscountedPrice();
        orderHistory.cancelYn = order.getCancelYn();
        orderHistory.orderGoods.addAll(order.getOrderGoods());

        return orderHistory;
    }

}
