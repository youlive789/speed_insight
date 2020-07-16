package com.speed_insight.dashboard.repository;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.speed_insight.dashboard.model.MainScore;

@SpringBootTest
public class MainScoreRepositoryTests {
	
	@Autowired
	private MainScoreRepository repo;
	
	@Test
	void TestgetMainScoreByIds() {
		
		List<Long> ids = new ArrayList<Long>();
		ids.add(new Long(3));
		ids.add(new Long(4));
		ids.add(new Long(5));
		
		List<MainScore> lists = repo.findByIdIn(ids);
		for (MainScore ms : lists) {
			System.out.println(ms.getLargestContentfulPaint());
		}
	}

}
