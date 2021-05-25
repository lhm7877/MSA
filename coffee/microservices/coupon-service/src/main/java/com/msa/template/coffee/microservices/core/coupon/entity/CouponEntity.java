package com.msa.template.coffee.microservices.core.coupon.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

// XXX 박정호 : 이 쿠폰은 기프티콘과 같이 중복이 없고, 고유한 쿠폰번호를 가지며, 메뉴 공짜 쿠폰임
// XXX 박정호 : 멤버와 쿠폰은 다대일 관계
@Document(collection = "coupons")
public class CouponEntity {

    @Id
    private String id;

    private String couponNumber;    // 쿠폰번호 (ex. 3154-1355-1832-1234)
    private String productId;       // 제품 id
    private String productName;     // 제품 명 (ex. 아이스아메리카노)
    private int productPrice;       // 제품 금액
    private Long memberId;          // 쿠폰 사용자
    private Date expirationDate;  // 유효기간

    private CouponStatus couponStatus;  // 쿠폰상태(사용, 미사용, 만료)

    public CouponEntity() {
    }

    public CouponEntity(String couponNumber, String productId, String productName, int productPrice, Long memberId, Date expirationDate, CouponStatus couponStatus) {
        this.couponNumber = couponNumber;
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.memberId = memberId;
        this.expirationDate = expirationDate;
        this.couponStatus = couponStatus;
    }

    @Override
    public String toString() {
        return "CouponEntity{" +
                "id='" + id + '\'' +
                ", couponNumber='" + couponNumber + '\'' +
                ", productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", memberId=" + memberId +
                ", expirationDate='" + expirationDate + '\'' +
                ", couponStatus=" + couponStatus +
                '}';
    }
}
