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
		File target = jsonLists[0];
		
		String targetJsonString = "";
		try {
			targetJsonString = this.readTargetJsonFile(target.getCanonicalPath());
			//this.deleteFile(target);
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
	
	private void deleteFile(File target) {
		target.delete();
	}
}
