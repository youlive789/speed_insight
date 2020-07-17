package com.speed_insight.dashboard.repository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
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
		
		Calendar calendar = Calendar.getInstance();
		
		calendar.set(2017, Calendar.MARCH, 1);
		Date start1 = new Date(calendar.getTimeInMillis());
		
		calendar.set(2017, Calendar.APRIL, 1);
		Date end1 = new Date(calendar.getTimeInMillis());
		
		List<Master> lists = repo.findByDateBetween(start1, end1);
		System.out.println("첫번째 쿼리");
		for (Master m : lists) 
			System.out.println(m.getId());
		
		calendar.set(2020, Calendar.JULY, 13);
		Date start2 = new Date(calendar.getTimeInMillis());
		
		calendar.set(2020, Calendar.JULY, 15);
		Date end2 = new Date(calendar.getTimeInMillis());
	
		List<Master> list = repo.findByDateBetween(start2, end2);
		System.out.println("두번째 쿼리");
		for (Master m : list) 
			System.out.println(m.getId());
	}
	
	@Test
	void testGetIdsByUrls() {
		List<String> urls = new ArrayList<String>();
		urls.add("https://www.naver.com/");
		urls.add("https://www.hankyung.com/");
		
		List<Master> lists = repo.findByUrlIn(urls);
		for (Master m : lists) {
			System.out.println(m.getId() + " " + m.getUrl());
		}
	}
}
