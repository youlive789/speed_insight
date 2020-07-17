package com.speed_insight.dashboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.speed_insight.dashboard.model.Master;
import com.speed_insight.dashboard.repository.MasterRepository;

@Service
public class MasterService {
	
	@Autowired
	private MasterRepository masterRepository;
	
	public List<Master> getMasterByUrls(List<String> urls) {
		return masterRepository.findByUrlIn(urls);
	}
	
}
