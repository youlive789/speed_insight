package com.speed_insight.processor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ScheduledExecutorFactoryBean;

import com.speed_insight.processor.service.MasterService;

@SpringBootApplication
@EnableScheduling
public class ProcessorApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ProcessorApplication.class, args);
	}

	@Bean
	public ScheduledExecutorFactoryBean scheduledExecutorService() {
		ScheduledExecutorFactoryBean bean = new ScheduledExecutorFactoryBean();
		bean.setPoolSize(8);
		return bean;
	}
}
