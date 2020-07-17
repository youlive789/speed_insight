package com.speed_insight.dashboard.repository;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.speed_insight.dashboard.model.NetworkServerLatency;

@SpringBootTest
public class NetworkServerLatencyRepositoryTests {
	
	@Autowired
	private NetworkServerLatencyRepository repo;
	
	@Test
	void testFindByIdIn() {
		List<Long> idList = new ArrayList<Long>();
		idList.add(new Long(123));
		
		List<NetworkServerLatency> lists = repo.findByIdIn(idList);
		System.out.println(lists.toString());
		for (NetworkServerLatency n : lists) {
			System.out.println(n.getOrigin().toString() + " " + n.getServerResponseTime().toString());
		}
		
	}
}
