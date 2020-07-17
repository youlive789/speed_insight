package com.speed_insight.processor.service;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.speed_insight.processor.model.MainScore;
import com.speed_insight.processor.model.Master;
import com.speed_insight.processor.repository.MainScoreRepository;

@Service
public class MainScoreService {
	
	@Autowired
	private MainScoreRepository mainScoreRepository;
	
	public void setMainScoreData(Master id, JSONObject target) {
		this.processTarget(id, target);
	}
	
	private void processTarget(Master id, JSONObject target) {
		
		JSONObject audits = (JSONObject)target.get("audits");
		
		JSONObject fcp = (JSONObject)audits.get("first-contentful-paint");
		Float fcpScore = Float.parseFloat(fcp.get("score").toString());
		
		JSONObject si = (JSONObject)audits.get("speed-index");
		Float siScore = Float.parseFloat(si.get("score").toString());
		
		JSONObject lcp = (JSONObject)audits.get("largest-contentful-paint");
		Float lcpScore = Float.parseFloat(lcp.get("score").toString());
		
		JSONObject interactive = (JSONObject)audits.get("interactive");
		Float interScore = Float.parseFloat(interactive.get("score").toString());
		
		JSONObject tbt = (JSONObject)audits.get("total-blocking-time");
		Float tbtScore = Float.parseFloat(tbt.get("score").toString());
		
		JSONObject cls = (JSONObject)audits.get("cumulative-layout-shift");
		Float clsScore = Float.parseFloat(cls.get("score").toString());
		
		MainScore mainScore = new MainScore(
			id, fcpScore, siScore, lcpScore, interScore, tbtScore, clsScore
		);
		
		mainScoreRepository.save(mainScore);
	}
}
