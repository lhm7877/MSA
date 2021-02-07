package com.msa.jparepository;

import com.msa.jpaentity.review.ReviewEntity;
import com.msa.jpaentity.review.ReviewEntityPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewEntityRepository extends JpaRepository<ReviewEntity, ReviewEntityPK> {
}
