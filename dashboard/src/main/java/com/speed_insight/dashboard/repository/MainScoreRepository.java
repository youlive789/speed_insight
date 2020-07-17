package com.speed_insight.dashboard.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.speed_insight.dashboard.model.MainScore;
import com.speed_insight.dashboard.model.Master;

@Repository
public interface MainScoreRepository extends JpaRepository<MainScore, Long> {
	public List<MainScore> findByMasterIn(Collection<Master> idList); 
}
