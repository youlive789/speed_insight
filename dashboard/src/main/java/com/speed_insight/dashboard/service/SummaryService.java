package com.speed_insight.dashboard.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.speed_insight.dashboard.model.Master;
import com.speed_insight.dashboard.repository.SummaryRepository;

@Service
public class SummaryService {
	
	@Autowired
	private SummaryRepository summaryRepository;
	
	public Float getAvgMaxServerLatency(Collection<Master> idList) {
		return summaryRepository.findAverageOfMaxServerLatencyByMasterIn(idList);
	}
	
	public Float getAvgTotalTaskTime(Collection<Master> idList) {
		return summaryRepository.findAverageOfTotalTaskTimeByMasterIn(idList);
	}
}
