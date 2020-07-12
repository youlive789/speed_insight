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
		
		// JSON ������ �ƹ��͵� ���ٸ� �� ��ü�� �����Ѵ�.
		if (jsonLists.length < 1) return new JSONObject();
		File target = jsonLists[0];
		
		// ���� �۾��� �Ϸ���� ���� �����̶�� �� ��ü�� �����Ѵ�.
		if (target.getTotalSpace() < 10) return new JSONObject();
		
		String targetJsonString = "";
		try {
			targetJsonString = this.readTargetJsonFile(target.getCanonicalPath());
			
			// GC�� ���� ���� ��ü�� �����ִٸ� ���� ������ �ȵȴ�.
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
