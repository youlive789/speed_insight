package com.speed_insight.collector;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.speed_insight.collector.utils.CollectTargetParser;

@Component
public class CollectorCron {

	private List<String> targetList;
	
	private String shellCmd;
	//private final static String LIGHTHOUSE_CMD = "docker run --rm lighthouse ";
	private final static String LIGHTHOUSE_CMD = "/usr/bin/lighthouse --output json --throttling-method=provided --chrome-flags=\"--headless --no-sandbox\" --quiet --only-categories=performance --emulated-form-factor=";
	
	public CollectorCron() {
		super();
		prepareTargetJson();
	}
	
	private void prepareTargetJson() {
		File dataPath = new File("../data");
		if (!dataPath.exists()) dataPath.mkdir();
		
		CollectTargetParser targetParser = new CollectTargetParser();
		try {
			this.targetList = targetParser.getCollectTargetList();
		} catch (Exception e) {
			System.out.println("target.json이 없습니다!");
		}
	}
	
	@Scheduled(cron="0 * * * * *")
	public void desktopJob() throws Exception {
		prepareTargetJson();
		if (this.targetList != null) {
			executeCommand("desktop");
		}
	}
	
	@Scheduled(cron="10 * * * * *")
	public void mobileJob() throws Exception {
		prepareTargetJson();
		if (this.targetList != null) {
			executeCommand("mobile");
		}
	}
	
	private void executeCommand(String deviceFlag) {		

		StringBuffer successOutput = new StringBuffer();
        StringBuffer errorOutput = new StringBuffer();
		BufferedReader successBufferReader = null;
		BufferedReader errorBufferReader = null;
		String msg = null;
		
		List<String> command = null;
		
		File tmpPath = new File("../data/tmp");
		if (!tmpPath.exists()) tmpPath.mkdir();
		
		for (String target : this.targetList) {
			System.out.println("Now Target : " + target);
			try {
				
				String currentCmd = LIGHTHOUSE_CMD + deviceFlag + " " + target + " > ../data/tmp/" + this.getDateString() + "." + deviceFlag + ".json";
				System.out.println(currentCmd);
				
				command = new ArrayList<String>();
				command.add("/bin/sh");
				command.add("-c");
				command.add(currentCmd);
				
				ProcessBuilder pb = new ProcessBuilder(command);
				Process process = pb.start();

				// shell 실행이 정상 동작했을 경우
	            successBufferReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
	            while ((msg = successBufferReader.readLine()) != null) {
	                successOutput.append(msg + System.getProperty("line.separator"));
	            }
	 
	            // shell 실행시 에러가 발생했을 경우
	            errorBufferReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
	            while ((msg = errorBufferReader.readLine()) != null) {
	                errorOutput.append(msg + System.getProperty("line.separator"));
	            }
				
				process.waitFor();
				
				// shell 실행이 정상 종료되었을 경우
	            if (process.exitValue() == 0) {
	                System.out.println("성공 " + process.exitValue());
	                System.out.println(successOutput.toString());
	            } else {
	                // shell 실행이 비정상 종료되었을 경우
	                System.out.println("비정상 종료 " + process.exitValue());
	                System.out.println(successOutput.toString());
	            }
	 
	            // shell 실행시 에러가 발생
	            if (!StringUtils.isEmpty(errorOutput.toString())) {
	                // shell 실행이 비정상 종료되었을 경우
	                System.out.println("오류");
	                System.out.println(errorOutput.toString());
	            }
	            
	            process.destroy();
			} 
			catch (IOException | InterruptedException e) {
				e.printStackTrace();
			} 
			finally {
				try {
	                if (successBufferReader != null) successBufferReader.close();
	                if (errorBufferReader != null) errorBufferReader.close();
	            } catch (IOException e1) {
	                e1.printStackTrace();
	            }
			}
		}
	}
	
	private String getDateString() {
		Date time = new Date();
		SimpleDateFormat format = new SimpleDateFormat ("yyyyMMddHHmm");				
		String result = format.format(time);
		
		double dValue = Math.random();
	    char cValue = (char)((dValue * 26) + 65);
		result += cValue;
	    
		return result;
	}
}


