package com.speed_insight.processor;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.speed_insight.processor.service.MainScoreService;
import com.speed_insight.processor.service.MasterService;
import com.speed_insight.processor.service.SummaryService;
import com.speed_insight.processor.utils.DataParser;

@Component
public class ProcessorCron {
	
	@Autowired
	private DataParser dataParser;
	
	@Autowired
	private MasterService masterService;
	
	@Autowired
	private MainScoreService mainScoreService;
	
	@Autowired
	private SummaryService summaryService;
	
	@Scheduled(cron="* * * * * *")
	public void saveJson() throws Exception {
		
		JSONObject target = dataParser.nextTargetData();
		
		Long id = masterService.setMasterData(target);
		mainScoreService.setMainScoreData(id, target);
		summaryService.setSummaryData(id, target);
	}
}
