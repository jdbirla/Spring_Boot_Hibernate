package com.luv2code.springdemo;

import javax.management.loading.PrivateClassLoader;

public class CricketCoach implements Coach{

	private FortuneService fortuneService;
	
	private String emailAddress ;
	private String team ;


	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	
	public String getEmailAddress() {
		return emailAddress;
	}

	public String getTeam() {
		return team;
	}

	public CricketCoach() {
		System.out.println("Inside no arg constucor of cricket coach");
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Daily work out for cricket";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}
	
	
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("Setter method of cricket coach setFortune");
		this.fortuneService = fortuneService;
	}
	

}
