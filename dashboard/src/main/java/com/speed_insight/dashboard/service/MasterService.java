package com.speed_insight.dashboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.speed_insight.dashboard.repository.MasterRepository;

@Service
public class MasterService {
	
	@Autowired
	private MasterRepository masterRepository;
	
}
