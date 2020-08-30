package com.speed_insight.dashboard.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.speed_insight.dashboard.model.Master;
import com.speed_insight.dashboard.model.NetworkServerLatency;

public interface NetworkServerLatencyRepository extends JpaRepository<NetworkServerLatency, Long>{
	public List<NetworkServerLatency> findByMaster(Master id);
	public List<NetworkServerLatency> findByMasterIn(Collection<Master> idList); 
}
