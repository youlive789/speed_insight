package com.speed_insight.dashboard.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.speed_insight.dashboard.model.Master;
import com.speed_insight.dashboard.model.NetworkServerLatency;

@SpringBootTest
public class NetworkServerLatencyRepositoryTests {
	
	@Autowired
	private MasterRepository masterRepo;
	
	@Autowired
	private NetworkServerLatencyRepository repo;
	
	@Test
	void testFindByIdIn() {
		List<Master> idList = new ArrayList<Master>();
		Optional<Master> res = masterRepo.findById(new Long(25));
		res.ifPresent(idList::add);
		
		List<NetworkServerLatency> lists = repo.findByMasterIn(idList);
		System.out.println(lists.toString());
		for (NetworkServerLatency n : lists) {
			System.out.println(n.getOrigin().toString() + " " + n.getServerResponseTime().toString());
		}
		
	}
}
