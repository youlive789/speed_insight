package com.speed_insight.dashboard.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.speed_insight.dashboard.model.MainScore;
import com.speed_insight.dashboard.model.Master;
import com.speed_insight.dashboard.model.submodel.AvgMainScore;

@Repository
public interface MainScoreRepository extends JpaRepository<MainScore, Long> {
	public List<MainScore> findByMasterIn(Collection<Master> idList); 
	
	@Query(value= "SELECT new com.speed_insight.dashboard.model.submodel.AvgMainScore(" +
						 "AVG(m.firstContentfulPaint) as firstContentfulPaint, " + 
						 "AVG(m.speedIndex) as speedIndex, " + 
						 "AVG(m.largestContentfulPaint) as largestContentfulPaint, " + 
						 "AVG(m.timeToInteractive) as timeToInteractive, " + 
						 "AVG(m.totalBlockingTime) as totalBlockingTime, " + 
						 "AVG(m.cumulativeLayoutShift) as cumulativeLayoutShift) " + 
			        "FROM MAIN_SCORE m WHERE m.master in (?1)")
	public AvgMainScore findAverageOfMainScoreByMasterIn(Collection<Master> idList);
}
