package com.speed_insight.processor.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Builder;
import lombok.Data;

@Data
@Embeddable
public class NetworkServerLatencyId implements Serializable {
	
	@Column(name="Id")
	private Long Id;
	
	@Column(name="ORIGIN")
	private String origin;
	
	public NetworkServerLatencyId() {}
	
	@Builder
	public NetworkServerLatencyId(Long id, String origin) {
		this.Id = id;
		this.origin = origin;
	}
}
