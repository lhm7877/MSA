package com.msa.mongoentity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import javax.persistence.Version;
import java.lang.annotation.Documented;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Document(collection = "recommendation")
public class RecommendationEntity {

    @Id
    private String id;

    @Version
    private int version;

    private int productId;
    private int recommendationId;
    private String author;
    private int rate;
    private String content;

    @Builder
    public RecommendationEntity(String id, int version, int productId, int recommendationId, String author, int rate, String content){
        this.id = id;
        this.version = version;
        this.productId = productId;
        this.recommendationId = recommendationId;
        this.author = author;
        this.rate =rate;
        this.content = content;
    }
}

