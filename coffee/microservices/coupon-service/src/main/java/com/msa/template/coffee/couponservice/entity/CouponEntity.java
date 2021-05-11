package com.msa.template.coffee.couponservice.entity;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Version;

// XXX 박정호 : 이 쿠폰은 기프티콘과 같이 중복이 없고, 고유한 쿠폰번호를 가지며, 메뉴 공짜 쿠폰임
// XXX 박정호 : 멤버와 쿠폰은 다대일 관계
@Document(collection = "coupon")
public class CouponEntity {

    @Id
    private String id;

    @Version
    private Integer version;

    @Indexed(unique = true)
    private int couponId;

    private String productId;       // 제품 id
    private String productName;     // 제품 명 (ex. 아이스아메리카노)
    private int productPrice;       // 할인금액
    private String couponNumber;    // 쿠폰번호 (ex. 3154-1355-1832-1234)
    private Long memberId;          // 쿠폰 사용자

    @Enumerated(EnumType.STRING)
    private CouponStatus couponStatus;  // 쿠폰상태(사용, 미사용, 만료)
}
