package com.speed_insight.dashboard.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Builder;

@Entity(name="NETWORK_SERVER_LATENCY")
public class NetworkServerLatency {
	
	@Id
	@Column(name="NETWORK_SERVER_LATENCY_ID")
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
	public NetworkServerLatency(Master id, String origin, Float serverResponseTime) {
		this.master = id;
		this.origin = origin;
		this.serverResponseTime = serverResponseTime;
	}

	public Long getId() {
		return this.id;
	}

	public String getOrigin() {
		return this.origin;
	}

	public Float getServerResponseTime() {
		return serverResponseTime;
	}

	public void setServerResponseTime(Float serverResponseTime) {
		this.serverResponseTime = serverResponseTime;
	}
	
	
}
