package com.msa.template.coffee.review.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "review")
public class ReviewEntity extends BaseTimeEntity{

    //TODO 이후민 : 이부분 비슷하게 고민을 좀 했었는데 reviewId가 따로 필요할까요?
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Version
    private long version;

    @Column(name = "user_id", nullable = false)
    private long userId;

    @Column(name = "product_id", nullable = false)
    private long productId;

    //TODO 이후민 : 내용을 뜻하는거라면 content가 더 명확해보여요
    @Column(name = "contents", nullable = false)
    private String contents;

    //TODO 이후민 : 소수점 처리도 가능하도록 바꾸는게 좋아보여요
    @Column(name = "rating", nullable = false)
    private int rating;

}
