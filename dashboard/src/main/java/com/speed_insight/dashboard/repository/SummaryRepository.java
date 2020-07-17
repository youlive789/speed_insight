package com.speed_insight.dashboard.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.speed_insight.dashboard.model.Master;
import com.speed_insight.dashboard.model.ResourceSummary;
import com.speed_insight.dashboard.model.Summary;

@Repository
public interface SummaryRepository extends JpaRepository<Summary, Long>{
	public List<ResourceSummary> findByMasterIn(Collection<Master> idList);
}
