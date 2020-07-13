package com.speed_insight.dashboard.service;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.speed_insight.dashboard.model.MainScore;
import com.speed_insight.dashboard.repository.MainScoreRepository;

@Service
public class MainScoreService {
	
	@Autowired
	private MainScoreRepository mainScoreRepository;
	
}
