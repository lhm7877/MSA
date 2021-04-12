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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Version
    private long version;

    @Column(name = "user_id", nullable = false)
    private long userId;

    @Column(name = "product_id", nullable = false)
    private long productId;

    @Column(name = "contents", nullable = false)
    private String contents;

    @Column(name = "rating", nullable = false)
    private int rating;

}
