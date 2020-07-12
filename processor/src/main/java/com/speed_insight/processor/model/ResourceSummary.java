package com.speed_insight.processor.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import lombok.Builder;
import lombok.Data;

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