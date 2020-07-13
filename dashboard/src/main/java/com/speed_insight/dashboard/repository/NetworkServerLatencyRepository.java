package com.speed_insight.dashboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.speed_insight.dashboard.model.NetworkServerLatency;

public interface NetworkServerLatencyRepository extends JpaRepository<NetworkServerLatency, Long>{

}
