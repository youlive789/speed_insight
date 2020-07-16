package com.speed_insight.dashboard.repository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.speed_insight.dashboard.model.Master;

@SpringBootTest
public class MasterRepositoryTests {

	@Autowired
	private MasterRepository repo;
	
	@Test
	void testGetIdsByUrl() {
		List<Master> lists = repo.findByUrl("https://www.mk.co.kr/news/world/view/2020/07/694409/");
		List<Long> idList = new ArrayList<Long>();
		for (Master m : lists) {
			idList.add(m.getId());
		}
	}
	
	@Test
	void testGetIdsByDate() {
		Date start1 = new Date(2017, 3, 1);
		Date end1 = new Date(2017, 4, 1);
		
		List<Master> lists = repo.findByDateBetween(start1, end1);
		System.out.println("첫번째 쿼리");
		for (Master m : lists) 
			System.out.println(m.getId());
		
		Date start2 = new Date(2020, 6, 13);
		Date end2 = new Date(2020, 6, 15);
	
		List<Master> list = repo.findByDateBetween(start2, end2);
		System.out.println("두번째 쿼리");
		for (Master m : list) 
			System.out.println(m.getId());
	}
}
