package com.speed_insight.dashboard.repository;

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
		List<MainScore> scores = repo.findAll();
		System.out.println(scores);
	}

}
