package com.speed_insight.processor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.speed_insight.processor.model.ResourceSummary;

@Repository
public interface ResourceSummaryRepository extends JpaRepository<ResourceSummary, Long>{
}
