package com.speed_insight.collector.utils;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CollectTargetParserTests {
	
	@Test
	void test_can_read_target_json_file() {
		CollectTargetParser targetParser = new CollectTargetParser();
		List<String> targetList;
		try {
			targetList = targetParser.getCollectTargetList();
			for (String target : targetList) {
				System.out.println(target); 
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	void test_runtime() {
		Runtime rt = Runtime.getRuntime();
		try {
			Process process = rt.exec("cmd.exe /C lighthouse --help");
			BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
			
			Scanner scanner = new Scanner(br); 
			scanner.useDelimiter(System.getProperty("line.separator")); 
			while(scanner.hasNext()) 
				System.out.println(scanner.next());
			
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

}
