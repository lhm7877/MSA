package com.msa.mongorepository;

import com.msa.mongoentity.RecommendationEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecommendationEntityRepository extends MongoRepository<RecommendationEntity, String> {
}
