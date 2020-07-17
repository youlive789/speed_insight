package com.speed_insight.dashboard.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.speed_insight.dashboard.model.Master;
import com.speed_insight.dashboard.model.ResourceSummary;
import com.speed_insight.dashboard.model.Summary;

@Repository
public interface SummaryRepository extends JpaRepository<Summary, Long>{
	public List<ResourceSummary> findByMasterIn(Collection<Master> idList);
	
	@Query(value="SELECT AVG(s.MAX_SERVER_LATENCY) FROM SUMMARY s WHERE s.ID in (?1)", nativeQuery=true)
	public Float findAverageOfMaxServerLatencyByMasterIn(Collection<Master> idList);
	
	@Query(value="SELECT AVG(s.TOTAL_TASK_TIME) FROM SUMMARY s WHERE s.ID in (?1)", nativeQuery=true)
	public Float findAverageOfTotalTaskTimeByMasterIn(Collection<Master> idList);
}
