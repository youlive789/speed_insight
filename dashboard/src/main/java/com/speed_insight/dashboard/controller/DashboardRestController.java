package com.speed_insight.dashboard.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.speed_insight.dashboard.model.Master;
import com.speed_insight.dashboard.service.MainScoreService;
import com.speed_insight.dashboard.service.MasterService;
import com.speed_insight.dashboard.service.SummaryService;
import com.speed_insight.dashboard.service.TargetJsonService;
import com.speed_insight.dashboard.utils.CollectTargetParser;

@RestController
public class DashboardRestController {

	@Autowired
	private CollectTargetParser parser;
	
	@Autowired
	private MasterService masterService;
	
	@Autowired
	private SummaryService summaryService;
	
	@Autowired
	private MainScoreService mainScoreService;
	
	@Autowired
	private TargetJsonService targetJsonService;
	
	@GetMapping("/mainscore/avgPerformanceScore")
	public String avgPerformanceScoreByUrl() {
		Map<String, Integer> result = new HashMap<String, Integer>();
		List<String> urls = null;
		
		try {
			urls = parser.getCollectTargetList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		int idx = 0;
		List<ArrayList<Master>> idLists = masterService.getTargetUrlIds(urls);
		for (ArrayList<Master> list : idLists) {
			result.put(urls.get(idx), mainScoreService.getAvgPerformanceScore(list));
			idx++;
		}
		
		return new JSONObject(result).toJSONString();
	}
	
	@GetMapping("/summary/avgMaxLatencyTime")
	public String avgMaxLatencyTimeByUrl() {
		
		Map<String, Float> result = new HashMap<String, Float>();
		List<String> urls = null;
		
		try {
			urls = parser.getCollectTargetList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		int idx = 0;
		List<ArrayList<Master>> idLists = masterService.getTargetUrlIds(urls);
		for (ArrayList<Master> list : idLists) {
			result.put(urls.get(idx), summaryService.getAvgMaxServerLatency(list));
			idx++;
		}
		
		return new JSONObject(result).toJSONString();
	}
	
	@GetMapping("/summary/avgTotalTaskTime")
	public String avgTotalTaskTimeByUrl() {
		
		Map<String, Float> result = new HashMap<String, Float>();
		List<String> urls = null;
		
		try {
			urls = parser.getCollectTargetList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		int idx = 0;
		List<ArrayList<Master>> idLists = masterService.getTargetUrlIds(urls);
		for (ArrayList<Master> list : idLists) {
			result.put(urls.get(idx), summaryService.getAvgTotalTaskTime(list));
			idx++;
		}
		
		return new JSONObject(result).toJSONString();
	}
	
	@GetMapping("/target/getTargetJson")
	@ResponseBody
	public String getTargetJson() {
		
		String result;
		
		try {
			result = targetJsonService.getTargetJson();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = "{\"result\":\"fail\"}";
		}
		return result;
	}
	
	@PostMapping("/target/setTargetJson")
	@ResponseBody
	public String setTargetJson(@RequestParam String target) {
		
		boolean result = targetJsonService.saveTargetJson(target);
		
		if (result) {
			return "{\"result\":\"success\"}";
		}
		else {
			return "{\"result\":\"fail\"}";
		}
	}
	
}
