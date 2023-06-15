package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping(value = {"/","/dashboard"})
	String getDashboard() {		
		return "statis/statistics";
	}
}
