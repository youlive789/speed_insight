package com.speed_insight.dashboard.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.speed_insight.dashboard.model.NetworkServerLatency;

public interface NetworkServerLatencyRepository extends JpaRepository<NetworkServerLatency, Long>{
	public List<NetworkServerLatency> findByIdIn(Collection<Long> idList); 
}
