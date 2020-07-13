package com.speed_insight.dashboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.speed_insight.dashboard.model.Summary;

@Repository
public interface SummaryRepository extends JpaRepository<Summary, Long>{
}
