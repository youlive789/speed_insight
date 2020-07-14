package com.speed_insight.dashboard.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Builder;

@Entity(name="RESOURCE_SUMMARY")
public class ResourceSummary {
	
	@EmbeddedId
	private ResourceSummaryId resourceSummaryId;
	
	@Column(name="REQUEST_COUNT")
	private Integer requestCount;
	
	@Column(name="SIZE")
	private Integer size;
	
	public ResourceSummary() {}

	@Builder
	public ResourceSummary(ResourceSummaryId resourceSummaryId, Integer requestCount, Integer size) {
		this.resourceSummaryId = resourceSummaryId;
		this.requestCount = requestCount;
		this.size = size;
	}
}