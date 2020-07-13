package com.speed_insight.dashboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {
	
	@GetMapping("/")
	public String dashboardMain(Model model) {
		model.addAttribute("greeting", "hello");
		return "main";
	}	
}
