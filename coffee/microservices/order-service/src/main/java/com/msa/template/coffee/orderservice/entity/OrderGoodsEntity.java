package com.msa.template.coffee.orderservice.entity;

import lombok.Getter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity(name = "order_goods")
@Table(indexes = {
        @Index(columnList = "menuId")
})
//XXX 이후민 : entity는 suffix로 Entity 붙이는건 어때요?
public class OrderGoodsEntity {

    @Id
    private Long id;

    @Column(nullable = false)
    private Long menuId;

    private Long parentMenuId;

    //XXX 이후민 : @Embedded 사용해보는건 어때요?
    @Column(precision = 5, scale = 2)
    private BigDecimal originalPrice;

    @Column(precision = 5, scale = 2)
    private BigDecimal discountPercent;

    @Column(precision = 5, scale = 2)
    private BigDecimal discountedPrice;

    //XXX 이후민 : 일급 컬렉션을 사용해보는건 어때요? https://bgpark.tistory.com/156
    @JoinColumn(name = "order_goods_id")
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<OrderGoodsEntity> options = new ArrayList<>();

    public List<OrderGoodsEntity> addOptions(List<OrderGoodsEntity> options) {
        this.options.addAll(options);
        return this.options;
    }

    public List<OrderGoodsEntity> removeOptions(List<OrderGoodsEntity> options) {
        this.options.removeAll(options);
        return this.options;
    }

    public static OrderGoodsEntity create(Long menuId, Long parentMenuId, BigDecimal originalPrice,
                                          BigDecimal discountPercent, BigDecimal discountedPrice, List<OrderGoodsEntity> options) {
        OrderGoodsEntity orderGoodsEntity = new OrderGoodsEntity();

        orderGoodsEntity.menuId = menuId;
        orderGoodsEntity.parentMenuId = parentMenuId;
        orderGoodsEntity.originalPrice = originalPrice;
        orderGoodsEntity.discountPercent = discountPercent;
        orderGoodsEntity.discountedPrice = discountedPrice;
        orderGoodsEntity.options.addAll(options);

        return orderGoodsEntity;
    }

}
