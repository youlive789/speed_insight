package com.speed_insight.processor.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Builder;

@Entity(name="NETWORK_SERVER_LATENCY")
public class NetworkServerLatency {
	
	@Id
	@Column(name="NETWORK_SERVER_LATENCY_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="ID")
	private Master master;
	
	@Column(name="ORIGIN")
	private String origin;
	
	@Column(name="SERVER_RESPONSE_TIME")
	private Float serverResponseTime;
	
	public NetworkServerLatency() {}
	
	@Builder
	public NetworkServerLatency(Master master, String origin, Float serverResponseTime) {
		this.master = master;
		this.origin = origin;
		this.serverResponseTime = serverResponseTime;
	}
}
