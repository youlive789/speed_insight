package com.speed_insight.dashboard.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Builder;

@Entity(name="RESOURCE_SUMMARY")
public class ResourceSummary {
	
	@Id
	@Column(name="ID")
	private Long id;
	
	@Column(name="RESOURCE_TYPE")
	private String resourceType;
	
	@Column(name="REQUEST_COUNT")
	private Integer requestCount;
	
	@Column(name="SIZE")
	private Integer size;
	
	public ResourceSummary() {}

	@Builder
	public ResourceSummary(Long id, String resourceType, Integer requestCount, Integer size) {
		this.id = id;
		this.resourceType = resourceType;
		this.requestCount = requestCount;
		this.size = size;
	}

	public Long getId() {
		return this.id;
	}

	public String getResourceType() {
		return this.resourceType;
	}

	public Integer getRequestCount() {
		return requestCount;
	}

	public void setRequestCount(Integer requestCount) {
		this.requestCount = requestCount;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}
	
	
}