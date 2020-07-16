package com.speed_insight.dashboard.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Builder;
import lombok.Data;

@Data
@Embeddable
public class ResourceSummaryId implements Serializable {

	@Column(name="ID")
	protected Long id;
	
	@Column(name="RESOURCE_TYPE")
	protected String resourceType;
	
	public ResourceSummaryId() {}
	
	@Builder
	public ResourceSummaryId(Long id, String resourceType) {
		this.id = id;
		this.resourceType = resourceType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getResourceType() {
		return resourceType;
	}

	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}
	
}