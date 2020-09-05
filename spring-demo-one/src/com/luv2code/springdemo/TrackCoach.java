package com.luv2code.springdemo;

public class TrackCoach implements Coach{

	private FortuneService fortuneService;
	
	public TrackCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Run a hard 5k";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return "just do it :" +fortuneService.getFortune();
	}
	
	//add init method 
	public void domyStartup() {
		
		System.out.println("Track coach : do my startup");
	}
	
	//add destroy method
	//beanLifeCycle-applicationContext.xml
	public void domyCleanUp() {
		
		System.out.println("Track coach : domyCleanUp");
	}
}
