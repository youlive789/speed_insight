package com.speed_insight.dashboard.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.speed_insight.dashboard.model.Master;
import com.speed_insight.dashboard.model.ResourceSummary;

@Repository
public interface ResourceSummaryRepository extends JpaRepository<ResourceSummary, Long>{
	public List<ResourceSummary> findByMasterIn(Collection<Master> idList); 
}
