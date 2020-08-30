package com.speed_insight.dashboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.speed_insight.dashboard.model.Master;
import com.speed_insight.dashboard.model.NetworkServerLatency;
import com.speed_insight.dashboard.repository.MasterRepository;
import com.speed_insight.dashboard.repository.NetworkServerLatencyRepository;

@Service
public class NetworkServerLatencyService {
	
	@Autowired
	private MasterRepository masterRepository;
	
	@Autowired
	private NetworkServerLatencyRepository networkServiceRepository;
	
	public List<NetworkServerLatency> getLatestNetworkLatencyByUrl(String url) {
		
		List<NetworkServerLatency> networkServerLatency = null;
		
		List<Master> ids = masterRepository.findByUrl(url);
		if (ids.size() < 1) {
			return networkServerLatency;
		}
		
		// 가장 최근의 데이터를 가져온다.
		int compare = 0;
		Master latestId = null;
		for (Master id : ids) {
			if (id.getId() > compare) {
				latestId = id;
			}
		}
			
		networkServerLatency = networkServiceRepository.findByMaster(latestId);
		return networkServerLatency;
	}
}
