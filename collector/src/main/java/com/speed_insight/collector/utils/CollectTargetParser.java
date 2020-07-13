package com.speed_insight.collector.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;

@Component
public class CollectTargetParser {
	
	final static String DIR_TARGET_JSON = "../data/target.json";

	public List<String> getCollectTargetList() throws Exception {
		
		List<String> targetList = new ArrayList<String>();
		
		String jsonString = this.readTargetJsonFile();
		JSONParser parser = new JSONParser();
		JSONObject jsonObject = null;
		
		try {
			jsonObject = (JSONObject)parser.parse(jsonString);
			JSONArray targetArray = (JSONArray)jsonObject.get("target");
			for (int idx = 0; idx < targetArray.size(); idx++) {
				targetList.add(targetArray.get(idx).toString());
			}
			
		} 
		catch (ParseException e) {
			e.printStackTrace();
		}
		
		return targetList;
	}
	
	private String readTargetJsonFile() throws Exception {

		FileReader targetFile;
		File checkTarget = new File(DIR_TARGET_JSON);
		String jsonString = "";
		
		if (!checkTarget.isFile()) throw new Exception("파일없음!");
		
		try {
			targetFile = new FileReader(DIR_TARGET_JSON);
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
