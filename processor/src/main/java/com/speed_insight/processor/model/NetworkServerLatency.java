package com.speed_insight.processor.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

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
}
