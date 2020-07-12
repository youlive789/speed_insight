package com.speed_insight.processor.service;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.speed_insight.processor.model.ResourceSummary;
import com.speed_insight.processor.model.ResourceSummaryId;
import com.speed_insight.processor.repository.ResourceSummaryRepository;

@Service
public class ResourceSummaryService {
	
	@Autowired
	private ResourceSummaryRepository resourceSummaryRepository;
	
	public void setSummaryData(Long id, JSONObject target) {
		this.processTarget(id, target);
	}
	
	private void processTarget(Long id, JSONObject target) {
		
		JSONObject audits = (JSONObject)target.get("audits");
		JSONObject rs = (JSONObject)audits.get("resource-summary");
		JSONObject details = (JSONObject)rs.get("details");
		JSONArray itemArray = (JSONArray)details.get("items"); 
		
		List<ResourceSummary> lists = new ArrayList<ResourceSummary>();
		for (int idx = 0; idx < itemArray.size(); idx++) {
			JSONObject item = (JSONObject)itemArray.get(idx);
			
			String resourceType = item.get("resourceType").toString();
			Integer requestCount = Integer.parseInt(item.get("requestCount").toString());
			Integer transferSizse = Integer.parseInt(item.get("transferSize").toString());
			
			ResourceSummaryId ids = new ResourceSummaryId(id, resourceType);
			ResourceSummary resourceSummary = new ResourceSummary(ids, requestCount, transferSizse);
			lists.add(resourceSummary);
		}
		
		resourceSummaryRepository.saveAll(lists);
		
	}
	
}
