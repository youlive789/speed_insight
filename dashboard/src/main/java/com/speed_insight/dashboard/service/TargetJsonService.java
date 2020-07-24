package com.speed_insight.dashboard.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.stereotype.Service;

@Service
public class TargetJsonService {

	private final String DIR_TARGET_JSON = "../data/target.json";
	
	public String getTargetJson() throws Exception {
		return readTargetJsonFile();
	}
	
	private String readTargetJsonFile() throws Exception {

		FileReader targetFile;
		File checkTarget = new File(DIR_TARGET_JSON);
		String jsonString = "";
		
		if (!checkTarget.isFile()) throw new Exception("타겟 파일이 없습니다!");
		
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
	
	public boolean saveTargetJson(String targetJson) {
		
		boolean result = true;
		File targetJsonFile = new File(DIR_TARGET_JSON);
		
		FileWriter fw;
		try {
			fw = new FileWriter(targetJsonFile);
			fw.write(targetJson);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
			result = false;
		}

		return result;
	}
}
