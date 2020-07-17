package com.speed_insight.processor.service;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.speed_insight.processor.model.Master;
import com.speed_insight.processor.model.Summary;
import com.speed_insight.processor.repository.SummaryRepository;

@Service
public class SummaryService {
	
	@Autowired
	private SummaryRepository summaryRepository;
	
	public void setSummaryData(Master id, JSONObject target) {
		this.processTarget(id, target);
	}
	
	private void processTarget(Master id, JSONObject target) {
		
		JSONObject audits = (JSONObject)target.get("audits");
		JSONObject diagnostics = (JSONObject)audits.get("diagnostics");
		JSONObject details = (JSONObject)diagnostics.get("details");
		
		JSONArray itemsArray = (JSONArray)details.get("items");
		JSONObject items = (JSONObject)itemsArray.get(0);
		
		Integer numRequests = Integer.parseInt(items.get("numRequests").toString());
		Integer numScripts = Integer.parseInt(items.get("numScripts").toString());
		Integer numFonts = Integer.parseInt(items.get("numFonts").toString());
		Integer numTasks = Integer.parseInt(items.get("numTasks").toString());
		Float rtt = Float.parseFloat(items.get("rtt").toString());
		Float throughput = Float.parseFloat(items.get("throughput").toString());
		Float maxRtt = Float.parseFloat(items.get("maxRtt").toString());
		Float maxServerLatency = Float.parseFloat(items.get("maxServerLatency").toString());
		Float totalByteWeight = Float.parseFloat(items.get("totalByteWeight").toString());
		Float totalTaskTime = Float.parseFloat(items.get("totalTaskTime").toString());
		Float mainDocumentTransferSize = Float.parseFloat(items.get("mainDocumentTransferSize").toString());

		Summary summary = new Summary( 
			id, numRequests, numScripts, numFonts, numTasks, rtt,
			throughput, maxRtt, maxServerLatency, totalByteWeight, totalTaskTime, mainDocumentTransferSize
		);
		
		summaryRepository.save(summary);
	}
}
