package com.speed_insight.dashboard.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.speed_insight.dashboard.model.Master;
import com.speed_insight.dashboard.repository.MasterRepository;
import com.speed_insight.dashboard.utils.CollectTargetParser;

@Service
public class MasterService {

	@Autowired
	private MasterRepository masterRepository;
	
	private final String DIR_TARGET_JSON = "../data/target.json";
	
	public List<ArrayList<Master>> getTargetUrlIds(List<String> urls) {
		
		List<ArrayList<Master>> targetUrlIds = new ArrayList<ArrayList<Master>>();
		
		try {
			for (String url : urls) {
				System.out.println(this.getMasterByUrl(url).toString());
				targetUrlIds.add((ArrayList<Master>) this.getMasterByUrl(url));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return targetUrlIds;
	}
	
	public List<Master> getMasterByUrl(String url) {
		return masterRepository.findByUrl(url);
	}
	
	public List<Master> getMasterByUrls(List<String> urls) {
		return masterRepository.findByUrlIn(urls);
	}
}
