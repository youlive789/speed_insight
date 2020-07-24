package com.speed_insight.dashboard.controller;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {
	
	@GetMapping("/")
	public String dashboardMain(Model model) {
		return "main";
	}	

	@GetMapping("/target")
	public String targetAddPage(Model model) {
		return "target";
	}
}
