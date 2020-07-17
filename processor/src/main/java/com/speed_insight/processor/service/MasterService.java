package com.speed_insight.processor.service;

import java.sql.Date;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.speed_insight.processor.model.Master;
import com.speed_insight.processor.repository.MasterRepository;

@Service
public class MasterService {
	
	@Autowired
	private MasterRepository masterRepository;
	
	public Master setMasterData(JSONObject target) {
		return this.processTarget(target);
	}
	
	private Master processTarget(JSONObject target) {
		
		String url = target.get("requestedUrl").toString();
		Date date = new Date(new java.util.Date().getTime());
		
		String device = "";
		JSONObject configSettings = (JSONObject)target.get("configSettings");
		String factor = configSettings.get("emulatedFormFactor").toString();
		switch (factor) {
			case "desktop" : 
				device = "W"; break;
			case "mobile" : 
				device = "M"; break;
			default : break;
		}
		
		Master master = new Master(url, date, device);
		masterRepository.save(master);
		
		return master;
	}
}
