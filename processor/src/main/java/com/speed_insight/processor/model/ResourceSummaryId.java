package com.speed_insight.processor.model;

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
}