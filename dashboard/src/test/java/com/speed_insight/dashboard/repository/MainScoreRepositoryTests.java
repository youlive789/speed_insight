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
	void test1() {
		
		List<Long> ids = new ArrayList<Long>();
		ids.add(new Long(123));
		ids.add(new Long(124));
		ids.add(new Long(125));
		
		List<MainScore> lists = repo.findByIdIn(ids);
		for (Method ms : lists.get(0).getClass().getMethods()) {
			System.out.println(ms.getName());
		}
			
			
	}

}
