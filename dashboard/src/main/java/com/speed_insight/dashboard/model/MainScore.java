package com.speed_insight.dashboard.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import lombok.Builder;

@Entity(name = "MAIN_SCORE")
public class MainScore {

	@Id
	@Column(name="ID")
	private Long id;
	
	@Column(name="FIRST_CONTENTFUL_PAINT")
	private Float firstContentfulPaint;
	
	@Column(name="SPEED_INDEX")
	private Float speedIndex;
	
	@Column(name="LARGEST_CONTENTFUL_PAINT")
	private Float largestContentfulPaint;
	
	@Column(name="TIME_TO_INTERACTIVE")
	private Float timeToInteractive;
	
	@Column(name="TOTAL_BLOCKING_TIME")
	private Float totalBlockingTime;
	
	@Column(name="CUMULATIVE_LAYOUT_SHIFT")
	private Float cumulativeLayoutShift;
	
	public MainScore() {}
	
	@Builder
	public MainScore(Long id, Float firstContentfulPaint, Float speedIndex, Float largestContentfulPaint, 
			Float timeToInteractive, Float totalBlockingTime, Float cumulativeLayoutShift) {
		this.id = id;
		this.firstContentfulPaint = firstContentfulPaint;
		this.speedIndex = speedIndex;
		this.largestContentfulPaint = largestContentfulPaint;
		this.timeToInteractive = timeToInteractive;
		this.totalBlockingTime = totalBlockingTime;
		this.cumulativeLayoutShift = cumulativeLayoutShift;
	}
}
