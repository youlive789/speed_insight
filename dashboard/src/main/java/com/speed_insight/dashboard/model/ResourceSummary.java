package com.speed_insight.dashboard.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Builder;

@Entity(name="RESOURCE_SUMMARY")
public class ResourceSummary {
	
	@Id
	@Column(name="RESOURCE_SUMMARY_ID")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="ID")
	private Master master;
	
	@Column(name="RESOURCE_TYPE")
	private String resourceType;
	
	@Column(name="REQUEST_COUNT")
	private Integer requestCount;
	
	@Column(name="SIZE")
	private Integer size;
	
	public ResourceSummary() {}

	@Builder
	public ResourceSummary(Master id, String resourceType, Integer requestCount, Integer size) {
		this.master = id;
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