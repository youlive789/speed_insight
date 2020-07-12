package com.speed_insight.processor.service;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.speed_insight.processor.model.NetworkServerLatency;
import com.speed_insight.processor.model.NetworkServerLatencyId;
import com.speed_insight.processor.repository.NetworkServerLatencyRepository;

@Service
public class NetworkServerLatencyService {
	
	@Autowired
	private NetworkServerLatencyRepository networkServiceRepository;
	
	public void setNetworkServerLatencyData(Long id, JSONObject target) {
		this.processTarget(id, target);
	}
	
	private void processTarget(Long id, JSONObject target) {
		
		JSONObject audits = (JSONObject)target.get("audits");
		JSONObject rs = (JSONObject)audits.get("network-server-latency");
		JSONObject details = (JSONObject)rs.get("details");
		JSONArray itemArray = (JSONArray)details.get("items"); 
		
		List<NetworkServerLatency> lists = new ArrayList<NetworkServerLatency>();
		for (int idx = 0; idx < itemArray.size(); idx++) {
			JSONObject item = (JSONObject)itemArray.get(idx);
			
			String origin = item.get("origin").toString();
			Float serverReponseTime = Float.parseFloat(item.get("serverResponseTime").toString());
			
			NetworkServerLatencyId ids = new NetworkServerLatencyId(id, origin);
			NetworkServerLatency networkServerLatency = new NetworkServerLatency(ids, serverReponseTime);
			lists.add(networkServerLatency);
		}
		
		networkServiceRepository.saveAll(lists);
	}
}
