package com.speed_insight.dashboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.speed_insight.dashboard.repository.NetworkServerLatencyRepository;

@Service
public class NetworkServerLatencyService {
	
	@Autowired
	private NetworkServerLatencyRepository networkServiceRepository;
}
