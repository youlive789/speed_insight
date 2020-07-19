package com.speed_insight.collector;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.speed_insight.collector.utils.CollectTargetParser;

@Component
public class CollectorCron {

	private List<String> targetList;
	private final static String LIGHTHOUSE_CMD = "cmd.exe /C lighthouse --output json --throttling-method=provided --chrome-flags=\"--headless --no-sandbox\" --quiet --only-categories=performance --emulated-form-factor=";
	
	public CollectorCron() {
		super();
		File dataPath = new File("../data");
		if (!dataPath.exists()) dataPath.mkdir();
		
		CollectTargetParser targetParser = new CollectTargetParser();
		try {
			this.targetList = targetParser.getCollectTargetList();
		} catch (Exception e) {
			System.out.println("target.json ������ �����ϴ�!");
		} 
	}
	
	@Scheduled(cron="0 * * * * *")
	public void desktopJob() throws Exception {
		if (this.targetList != null) {
			executeCommand("desktop");
		}
	}
	
	@Scheduled(cron="0 * * * * *")
	public void mobileJob() throws Exception {
		if (this.targetList != null) {
			executeCommand("mobile");
		}
	}
	
	private void executeCommand(String deviceFlag) {
		Runtime rt = Runtime.getRuntime();
		
		File tmpPath = new File("../data/tmp");
		if (!tmpPath.exists()) tmpPath.mkdir();
		
		for (String target : this.targetList) {
			System.out.println("Now Target : " + target);
			try {
				Process process = rt.exec(LIGHTHOUSE_CMD + deviceFlag + " " + target + " > ../data/tmp/" + this.getDateString() + "." + deviceFlag + ".json");
				process.waitFor();
			} 
			catch (IOException | InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	private String getDateString() {
		Date time = new Date();
		SimpleDateFormat format = new SimpleDateFormat ("yyyyMMddHHmm");				
		String result = format.format(time);
		return result;
	}
}


