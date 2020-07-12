package com.speed_insight.processor.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Builder;

@Entity(name = "SUMMARY")
public class Summary {
	
	@Id
	@Column(name="ID")
	private Long id;
	
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
	public Summary(Long id, Integer numRequest, Integer numScripts, Integer numFonts,
		Integer numTasks, Float rtt, Float throughput, Float maxRtt, Float maxServerLatency, 
		Float totalByteWeight, Float totalTaskTime, Float mainDocumentTransferSize
	) {
		this.id = id;
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
}
