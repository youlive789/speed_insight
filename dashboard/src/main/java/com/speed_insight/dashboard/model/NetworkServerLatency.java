package com.speed_insight.dashboard.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Builder;

@Entity(name="NETWORK_SERVER_LATENCY")
public class NetworkServerLatency {
	
	@Id
	@Column(name="Id")
	private Long id;
	
	@Column(name="ORIGIN")
	private String origin;
	
	@Column(name="SERVER_RESPONSE_TIME")
	private Float serverResponseTime;
	
	public NetworkServerLatency() {}
	
	@Builder
	public NetworkServerLatency(Long id, String origin, Float serverResponseTime) {
		this.id = id;
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
