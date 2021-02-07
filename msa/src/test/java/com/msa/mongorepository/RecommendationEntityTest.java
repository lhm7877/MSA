package com.msa.mongorepository;

import com.msa.config.TestMongoConfig;
import com.msa.mongoentity.RecommendationEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.ContextConfiguration;

import static org.assertj.core.api.Assertions.assertThat;

@DataMongoTest
@ContextConfiguration(classes = {TestMongoConfig.class})
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
@EnableAutoConfiguration
public class RecommendationEntityTest {

    @Autowired
    private RecommendationEntityRepository recommendationEntityRepository;


    @BeforeEach
    public void setup(){

    }

    @Test
    public void RecommendationEntity_조회_테스트(){
        RecommendationEntity recommendationEntity = RecommendationEntity.builder()
                .id("1")
                .productId(1)
                .author("srw1126")
                .recommendationId(1)
                .content("contents")
                .rate(5)
                .version(1)
                .build();

        RecommendationEntity savedRecommendationEntity = recommendationEntityRepository.save(recommendationEntity);

        assertThat(savedRecommendationEntity.getRecommendationId()).isEqualTo(recommendationEntity.getRecommendationId());
        assertThat(savedRecommendationEntity.getId()).isEqualTo(recommendationEntity.getId());
        assertThat(savedRecommendationEntity.getAuthor()).isEqualTo(recommendationEntity.getAuthor());
        assertThat(savedRecommendationEntity.getContent()).isEqualTo(recommendationEntity.getContent());
        assertThat(savedRecommendationEntity.getRate()).isEqualTo(recommendationEntity.getRate());
        assertThat(savedRecommendationEntity.getVersion()).isEqualTo(recommendationEntity.getVersion());

    }
}
