package com.speed_insight.processor.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Builder;

@Entity(name="RESOURCE_SUMMARY")
public class ResourceSummary {
	
	@Id
	@Column(name="RESOURCE_SUMMARY_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
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
	public ResourceSummary(Master master, String resourceType, Integer requestCount, Integer size) {
		this.master = master;
		this.resourceType = resourceType;
		this.requestCount = requestCount;
		this.size = size;
	}
}