package com.msa.repository;

import com.msa.entity.review.ReviewEntity;
import com.msa.entity.review.ReviewEntityPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewEntityRepository extends JpaRepository<ReviewEntity, ReviewEntityPK> {
}
