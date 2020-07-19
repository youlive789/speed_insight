package com.speed_insight.dashboard.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.speed_insight.dashboard.model.Master;
import com.speed_insight.dashboard.model.submodel.AvgMainScore;
import com.speed_insight.dashboard.repository.MainScoreRepository;

@Service
public class MainScoreService {
	
	@Autowired
	private MainScoreRepository mainScoreRepository;
	
	public Integer getAvgPerformanceScore(Collection<Master> idList) {
		AvgMainScore avgObj = mainScoreRepository.findAverageOfMainScoreByMasterIn(idList);
		
		Double weightedMean = new Double(0);
		weightedMean += (avgObj.getFirstContentfulPaint() * 0.15);
		weightedMean += (avgObj.getCumulativeLayoutShift() * 0.05);
		weightedMean += (avgObj.getLargestContentfulPaint() * 0.25);
		weightedMean += (avgObj.getSpeedIndex() * 0.15);
		weightedMean += (avgObj.getTimeToInteractive() * 0.15);
		weightedMean += (avgObj.getTotalBlockingTime() * 0.25);
		weightedMean *= 100;
		
		return weightedMean.intValue();
	}
}
