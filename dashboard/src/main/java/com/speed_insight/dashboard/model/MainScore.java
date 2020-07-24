package com.speed_insight.dashboard.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Builder;
import lombok.Data;

@Data
@Entity(name = "MAIN_SCORE")
public class MainScore {

	@Id
	@Column(name="MAIN_SCORE_ID")
	private Long id;
	
	@OneToOne
	@JoinColumn(name="ID")
	private Master master;
	
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
	
	public Float getFirstContentfulPaint() {
		return this.firstContentfulPaint;
	}
	
	@Builder
	public MainScore(Master id, Float firstContentfulPaint, Float speedIndex, Float largestContentfulPaint, 
			Float timeToInteractive, Float totalBlockingTime, Float cumulativeLayoutShift) {
		this.master = id;
		this.firstContentfulPaint = firstContentfulPaint;
		this.speedIndex = speedIndex;
		this.largestContentfulPaint = largestContentfulPaint;
		this.timeToInteractive = timeToInteractive;
		this.totalBlockingTime = totalBlockingTime;
		this.cumulativeLayoutShift = cumulativeLayoutShift;
	}
	
	public MainScore(Float firstContentfulPaint, Float speedIndex, Float largestContentfulPaint, 
			Float timeToInteractive, Float totalBlockingTime, Float cumulativeLayoutShift) {
		this.firstContentfulPaint = firstContentfulPaint;
		this.speedIndex = speedIndex;
		this.largestContentfulPaint = largestContentfulPaint;
		this.timeToInteractive = timeToInteractive;
		this.totalBlockingTime = totalBlockingTime;
		this.cumulativeLayoutShift = cumulativeLayoutShift;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Float getSpeedIndex() {
		return speedIndex;
	}

	public void setSpeedIndex(Float speedIndex) {
		this.speedIndex = speedIndex;
	}

	public Float getLargestContentfulPaint() {
		return largestContentfulPaint;
	}

	public void setLargestContentfulPaint(Float largestContentfulPaint) {
		this.largestContentfulPaint = largestContentfulPaint;
	}

	public Float getTimeToInteractive() {
		return timeToInteractive;
	}

	public void setTimeToInteractive(Float timeToInteractive) {
		this.timeToInteractive = timeToInteractive;
	}

	public Float getTotalBlockingTime() {
		return totalBlockingTime;
	}

	public void setTotalBlockingTime(Float totalBlockingTime) {
		this.totalBlockingTime = totalBlockingTime;
	}

	public Float getCumulativeLayoutShift() {
		return cumulativeLayoutShift;
	}

	public void setCumulativeLayoutShift(Float cumulativeLayoutShift) {
		this.cumulativeLayoutShift = cumulativeLayoutShift;
	}

	public void setFirstContentfulPaint(Float firstContentfulPaint) {
		this.firstContentfulPaint = firstContentfulPaint;
	}
	
}
