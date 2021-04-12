package com.msa.template.coffee.review.repository;

import com.msa.template.coffee.review.entity.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<ReviewEntity, Long> {

    public List<ReviewEntity> findAllByProductId(int productId);
}
