package com.speed_insight.dashboard.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Builder;

@Entity(name = "SUMMARY")
public class Summary {
	
	@Id
	@Column(name="SUMMARY_ID")
	private Long id;
	
	@OneToOne
	@JoinColumn(name="ID")
	private Master master;
	
	@Column(name="NUM_REQUEST")
	private Integer numRequest;
	
	@Column(name="NUM_SCRIPTS")
	private Integer numScripts;
	
	@Column(name="NUM_FONTS")
	private Integer numFonts;
	
	@Column(name="NUM_TASKS")
	private Integer numTasks;
	
	@Column(name="RTT")
	private Float rtt;
	
	@Column(name="THROUGHPUT")
	private Float throughput;
	
	@Column(name="MAX_RTT")
	private Float maxRtt;
	
	@Column(name="MAX_SERVER_LATENCY")
	private Float maxServerLatency;
	
	@Column(name="TOTAL_BYTE_WEIGHT")
	private Float totalByteWeight;
	
	@Column(name="TOTAL_TASK_TIME")
	private Float totalTaskTime;
	
	@Column(name="MAIN_DOCUMENT_TRANSFER_SIZE")
	private Float mainDocumentTransferSize;
	
	public Summary() {}
	
	@Builder
	public Summary(Master id, Integer numRequest, Integer numScripts, Integer numFonts,
		Integer numTasks, Float rtt, Float throughput, Float maxRtt, Float maxServerLatency, 
		Float totalByteWeight, Float totalTaskTime, Float mainDocumentTransferSize
	) {
		this.master = id;
		this.numRequest = numRequest;
		this.numScripts = numScripts;
		this.numFonts = numFonts;
		this.numTasks = numTasks;
		this.rtt = rtt;
		this.throughput = throughput;
		this.maxRtt = maxRtt;
		this.maxServerLatency = maxServerLatency;
		this.totalByteWeight = totalByteWeight;
		this.totalTaskTime = totalTaskTime;
		this.mainDocumentTransferSize = mainDocumentTransferSize;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNumRequest() {
		return numRequest;
	}

	public void setNumRequest(Integer numRequest) {
		this.numRequest = numRequest;
	}

	public Integer getNumScripts() {
		return numScripts;
	}

	public void setNumScripts(Integer numScripts) {
		this.numScripts = numScripts;
	}

	public Integer getNumFonts() {
		return numFonts;
	}

	public void setNumFonts(Integer numFonts) {
		this.numFonts = numFonts;
	}

	public Integer getNumTasks() {
		return numTasks;
	}

	public void setNumTasks(Integer numTasks) {
		this.numTasks = numTasks;
	}

	public Float getRtt() {
		return rtt;
	}

	public void setRtt(Float rtt) {
		this.rtt = rtt;
	}

	public Float getThroughput() {
		return throughput;
	}

	public void setThroughput(Float throughput) {
		this.throughput = throughput;
	}

	public Float getMaxRtt() {
		return maxRtt;
	}

	public void setMaxRtt(Float maxRtt) {
		this.maxRtt = maxRtt;
	}

	public Float getMaxServerLatency() {
		return maxServerLatency;
	}

	public void setMaxServerLatency(Float maxServerLatency) {
		this.maxServerLatency = maxServerLatency;
	}

	public Float getTotalByteWeight() {
		return totalByteWeight;
	}

	public void setTotalByteWeight(Float totalByteWeight) {
		this.totalByteWeight = totalByteWeight;
	}

	public Float getTotalTaskTime() {
		return totalTaskTime;
	}

	public void setTotalTaskTime(Float totalTaskTime) {
		this.totalTaskTime = totalTaskTime;
	}

	public Float getMainDocumentTransferSize() {
		return mainDocumentTransferSize;
	}

	public void setMainDocumentTransferSize(Float mainDocumentTransferSize) {
		this.mainDocumentTransferSize = mainDocumentTransferSize;
	}
}
