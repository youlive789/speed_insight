package com.speed_insight.collector;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.speed_insight.collector.utils.CollectTargetParser;

@Component
public class CollectorCron {
	
	private List<String> targetList;
	private final static String LIGHTHOUSE_CMD = "cmd.exe /C lighthouse --output json --throttling-method=provided --chrome-flags=\"--headless --no-sandbox\" --quiet --only-categories=performance --emulated-form-factor=";
	
	public CollectorCron() {
		super();
		CollectTargetParser targetParser = new CollectTargetParser();
		this.targetList = targetParser.getCollectTargetList(); 
	}
	
	@Scheduled(cron="0 * * * * *")
	public void desktopJob() throws Exception {
		executeCommand("desktop");
	}
	
	@Scheduled(cron="0 * * * * *")
	public void mobileJob() throws Exception {
		executeCommand("mobile");
	}
	
	private void executeCommand(String deviceFlag) {
		Runtime rt = Runtime.getRuntime();
		
		for (String target : this.targetList) {
			try {
				Process process = rt.exec(LIGHTHOUSE_CMD + deviceFlag + " " + target + " > ../data/tmp/" + this.getDateString() + "." + deviceFlag + ".json");
			} 
			catch (IOException e) {
				System.out.println();
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


