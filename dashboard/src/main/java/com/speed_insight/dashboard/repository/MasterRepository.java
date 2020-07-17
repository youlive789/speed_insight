package com.speed_insight.dashboard.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.speed_insight.dashboard.model.Master;

@Repository
public interface MasterRepository extends JpaRepository<Master, Long> {
	public List<Master> findByUrl(String url);
	public List<Master> findByUrlIn(List<String> urls);
	public List<Master> findByDateBetween(Date start, Date end);
}
