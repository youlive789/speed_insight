package com.speed_insight.dashboard.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.speed_insight.dashboard.model.Master;
import com.speed_insight.dashboard.model.NetworkServerLatency;

@SpringBootTest
public class NetworkServerLatencyServiceTests {
	
	@Autowired
	private NetworkServerLatencyService networkServerLatencyService;

	@Test
	void testGetLatestNetworkLatencyByUrl() {
		List<NetworkServerLatency> result = networkServerLatencyService.getLatestNetworkLatencyByUrl("https://www.naver.com/");
		for (NetworkServerLatency n : result) {
			System.out.println(n.getOrigin());
		}
	}
}
