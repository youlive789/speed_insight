package com.speed_insight.dashboard.model.submodel;

import javax.persistence.Entity;

import lombok.Builder;

public class AvgMainScore {

	public double getFirstContentfulPaint() {
		return firstContentfulPaint;
	}

	public void setFirstContentfulPaint(double firstContentfulPaint) {
		this.firstContentfulPaint = firstContentfulPaint;
	}

	public double getSpeedIndex() {
		return speedIndex;
	}

	public void setSpeedIndex(double speedIndex) {
		this.speedIndex = speedIndex;
	}

	public double getLargestContentfulPaint() {
		return largestContentfulPaint;
	}

	public void setLargestContentfulPaint(double largestContentfulPaint) {
		this.largestContentfulPaint = largestContentfulPaint;
	}

	public double getTimeToInteractive() {
		return timeToInteractive;
	}

	public void setTimeToInteractive(double timeToInteractive) {
		this.timeToInteractive = timeToInteractive;
	}

	public double getTotalBlockingTime() {
		return totalBlockingTime;
	}

	public void setTotalBlockingTime(double totalBlockingTime) {
		this.totalBlockingTime = totalBlockingTime;
	}

	public double getCumulativeLayoutShift() {
		return cumulativeLayoutShift;
	}

	public void setCumulativeLayoutShift(double cumulativeLayoutShift) {
		this.cumulativeLayoutShift = cumulativeLayoutShift;
	}

	private double firstContentfulPaint;
	private double speedIndex;
	private double largestContentfulPaint;
	private double timeToInteractive;
	private double totalBlockingTime;
	private double cumulativeLayoutShift;
	
	public AvgMainScore() {}
	
	@Builder
	public AvgMainScore(double firstContentfulPaint, double speedIndex, double largestContentfulPaint, 
			double timeToInteractive, double totalBlockingTime, double cumulativeLayoutShift) {
		this.firstContentfulPaint = firstContentfulPaint;
		this.speedIndex = speedIndex;
		this.largestContentfulPaint = largestContentfulPaint;
		this.timeToInteractive = timeToInteractive;
		this.totalBlockingTime = totalBlockingTime;
		this.cumulativeLayoutShift = cumulativeLayoutShift;
	}
}
