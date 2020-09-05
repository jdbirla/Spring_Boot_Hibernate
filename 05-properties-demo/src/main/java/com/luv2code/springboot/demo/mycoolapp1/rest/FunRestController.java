package com.luv2code.springboot.demo.mycoolapp1.rest;

import java.time.LocalDate;

import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
	
	@Value("${coach.name}")
	private String coachName;
	@Value("${team.name}")
	private String teamName;
	
	
	//Team 
	@GetMapping("/teaminfo")
	public String getTeamInfo()
	{
		return "Coach :" +coachName + " Team Name: " +teamName;
	}
	
	

	// Exposed "/" that

	@GetMapping("/")
	public String sayHello() {
		return "Hello World!!! Time on server is :" + LocalDate.now();

	}
	
	//exposed a new endpoint  
	@GetMapping("/workout")
	public String getDailyWorkOut()
	{
		return "Your are doing daily workout";
	}
}
