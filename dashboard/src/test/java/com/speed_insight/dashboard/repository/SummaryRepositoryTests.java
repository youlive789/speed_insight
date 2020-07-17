package com.speed_insight.dashboard.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.speed_insight.dashboard.model.Master;
import com.speed_insight.dashboard.model.Summary;

@SpringBootTest
public class SummaryRepositoryTests {
	@Autowired
	private MasterRepository masterRepo;
	
	@Autowired
	private SummaryRepository repo;
	
	@Test
	void testAvgMethod() {
		
		List<Master> idList = new ArrayList<Master>();
		
		Optional<Master> res = masterRepo.findById(new Long(1));
		idList.add(res.get());
		res = masterRepo.findById(new Long(25));
		idList.add(res.get());
		 
		Float latencyAvg = repo.findAverageOfMaxServerLatencyByMasterIn(idList);
		System.out.println(latencyAvg);
	}
	
}
