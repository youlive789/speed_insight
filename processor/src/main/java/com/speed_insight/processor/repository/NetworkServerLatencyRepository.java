package com.speed_insight.processor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.speed_insight.processor.model.NetworkServerLatency;

public interface NetworkServerLatencyRepository extends JpaRepository<NetworkServerLatency, Long>{

}
