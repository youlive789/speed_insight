package com.speed_insight.dashboard.controller;

import org.json.simple.JSONObject;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DashboardRestController {

	@GetMapping("/test")
	public String test1(Model model) {
		
		JSONObject attributes = new JSONObject();
		attributes.put("test", "123");
		attributes.put("test1", "123");
		attributes.put("test2", "123");
	
		return attributes.toJSONString();
	}
	
	 
	
	
}
