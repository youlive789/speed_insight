package com.speed_insight.processor.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;

@Component
public class DataParser {
	
	final static String DIR_DATA_JSON = "../data/tmp";
	
	public JSONObject nextTargetData() {
		return this.getTargetJson();
	}
	
	private JSONObject getTargetJson() {
		File dirDataJson = new File(DIR_DATA_JSON);
		File[] jsonLists = dirDataJson.listFiles();
		
		// JSON 폴더에 아무것도 없다면 빈 객체를 리턴한다.
		if (jsonLists.length < 1) return new JSONObject();
		File target = jsonLists[0];
		
		// 아직 작업이 완료되지 않은 파일이라면 빈 객체를 리턴한다.
		if (target.getTotalSpace() < 10) return new JSONObject();
		
		String targetJsonString = "";
		try {
			targetJsonString = this.readTargetJsonFile(target.getCanonicalPath());
			
			// GC에 아직 파일 객체가 남아있다면 파일 삭제가 안된다.
			System.gc();
			target.delete();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
		JSONObject targetJson = null;
		JSONParser parser = new JSONParser();
		try {
			targetJson = (JSONObject)parser.parse(targetJsonString);
		} 
		catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return targetJson;
	}
	
	private String readTargetJsonFile(String dirTarget) {
		FileReader targetFile;
		String jsonString = "";
		
		try {
			targetFile = new FileReader(dirTarget);
			BufferedReader br = new BufferedReader(targetFile);
			
			String tmp = null;
			while ((tmp = br.readLine()) != null) {
				jsonString += tmp;
			}			
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
		return jsonString;
	}
}
