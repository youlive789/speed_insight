package com.speed_insight.dashboard.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.speed_insight.dashboard.model.MainScore;
import com.speed_insight.dashboard.model.Master;
import com.speed_insight.dashboard.model.submodel.AvgMainScore;

@SpringBootTest
public class MainScoreRepositoryTests {
	
	@Autowired
	private MasterRepository masterRepo;
	
	@Autowired
	private MainScoreRepository repo;
	
	@Test
	void TestGetAvgMainscoreByIds() {
		List<String> urls = new ArrayList<String>();
		urls.add("https://www.naver.com/");
		
		List<Master> ids = masterRepo.findByUrlIn(urls);
		AvgMainScore res = repo.findAverageOfMainScoreByMasterIn(ids);
		System.out.println(res.getCumulativeLayoutShift() + " " + res.getLargestContentfulPaint());
	}
	
	@Test
	void TestgetMainScoreByIds() {
		List<Master> ids = new ArrayList<Master>();
		Optional<Master> res = masterRepo.findById(new Long(25));
		res.ifPresent(ids::add);
		System.out.println(ids.toString());
		
		List<MainScore> lists = repo.findByMasterIn(ids);
		for (MainScore ms : lists) {
			System.out.println(ms.getId() + " " + ms.getTimeToInteractive());
		}
	}

}
