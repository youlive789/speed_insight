package com.speed_insight.dashboard.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Builder;

@Entity(name="NETWORK_SERVER_LATENCY")
public class NetworkServerLatency {
	
	@EmbeddedId
	private NetworkServerLatencyId id;
	
	@Column(name="SERVER_RESPONSE_TIME")
	private Float serverResponseTime;
	
	public NetworkServerLatency() {}
	
	@Builder
	public NetworkServerLatency(NetworkServerLatencyId id, Float serverResponseTime) {
		this.id = id;
		this.serverResponseTime = serverResponseTime;
	}

	public Long getId() {
		return this.id.getId();
	}

	public String getOrigin() {
		return this.id.getOrigin();
	}

	public Float getServerResponseTime() {
		return serverResponseTime;
	}

	public void setServerResponseTime(Float serverResponseTime) {
		this.serverResponseTime = serverResponseTime;
	}
	
	
}
