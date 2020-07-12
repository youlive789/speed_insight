package com.speed_insight.processor.utils;

import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DataParserTests {
	
	@Test
	void test_next_target_data() {
		DataParser parser = new DataParser();
		JSONObject obj = parser.nextTargetData();
		
		JSONObject audits = (JSONObject)obj.get("audits");
		JSONObject fcp = (JSONObject)audits.get("first-contentful-paint");
		JSONObject fcpScore = (JSONObject)fcp.get("score");
	}
}
