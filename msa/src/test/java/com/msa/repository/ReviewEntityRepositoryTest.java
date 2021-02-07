package com.msa.repository;

import com.msa.entity.review.ReviewEntity;
import com.msa.config.TestJpaConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ContextConfiguration( classes = {TestJpaConfig.class} )
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class ReviewEntityRepositoryTest
{
    @Autowired
    private ReviewEntityRepository reviewEntityRepository;

    @BeforeEach
    public void setup(){
        // setup code
    }

    @Test
    public void ReviewEntity_테이블_조회_테스트(){
        ReviewEntity reviewEntity = ReviewEntity.builder()
                .reviewId(1)
                .productId(1)
                .author("srw1126")
                .subject("review")
                .content("contents")
                .build();

        ReviewEntity savedReviewEntity = reviewEntityRepository.save(reviewEntity);

        assertThat(savedReviewEntity.getReviewId()).isEqualTo(reviewEntity.getReviewId());
        assertThat(savedReviewEntity.getProductId()).isEqualTo(reviewEntity.getProductId());
        assertThat(savedReviewEntity.getAuthor()).isEqualTo(reviewEntity.getAuthor());
        assertThat(savedReviewEntity.getSubject()).isEqualTo(reviewEntity.getSubject());
        assertThat(savedReviewEntity.getContent()).isEqualTo(reviewEntity.getContent());
    }
}
