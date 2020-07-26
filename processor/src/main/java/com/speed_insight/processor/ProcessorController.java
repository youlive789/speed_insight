package com.speed_insight.processor;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.speed_insight.processor.model.Master;
import com.speed_insight.processor.service.MainScoreService;
import com.speed_insight.processor.service.MasterService;
import com.speed_insight.processor.service.NetworkServerLatencyService;
import com.speed_insight.processor.service.ResourceSummaryService;
import com.speed_insight.processor.service.SummaryService;
import com.speed_insight.processor.utils.DataParser;

@RestController
public class ProcessorController {
	@Autowired
	private DataParser dataParser;
	
	@Autowired
	private MasterService masterService;
	
	@Autowired
	private MainScoreService mainScoreService;
	
	@Autowired
	private SummaryService summaryService;
	
	@Autowired
	private ResourceSummaryService resourceSummaryService;
	
	@Autowired
	private NetworkServerLatencyService networkServerLatencyService;
	
	@GetMapping("/process")
	public String processAllData() {
		String result = "{\"result\":\"success\"}";
		
		try {
			List<JSONObject> targetList = dataParser.allTargetData();
			
			if (targetList == null || targetList.isEmpty()) {
				System.out.println("처리할 파일이 없습니다.");
			}
			else {
				for (JSONObject target : targetList) {
					Master id = masterService.setMasterData(target);
					mainScoreService.setMainScoreData(id, target);
					summaryService.setSummaryData(id, target);
					resourceSummaryService.setSummaryData(id, target);
					networkServerLatencyService.setNetworkServerLatencyData(id, target);
				}
			}
			
			System.gc();
		}
		catch (Exception e) {
			e.printStackTrace();
			result = "{\"result\":\"fail\"}";
		}
		
		return result;
	}
}
