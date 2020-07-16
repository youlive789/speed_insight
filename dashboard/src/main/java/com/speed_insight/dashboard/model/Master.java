package com.speed_insight.dashboard.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Builder;

@Entity(name="MASTER")
public class Master {
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="URL")
	private String url;
	
	@Column(name="DATE")
	private Date date;
	
	@Column(name="DEVICE")
	private String device;
	
	public Master() {}
	
	@Builder
	public Master(String url, Date date, String device) {
		this.url = url;
		this.date = date;
		this.device = device;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
