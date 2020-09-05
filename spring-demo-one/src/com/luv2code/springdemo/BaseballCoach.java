package com.luv2code.springdemo;

public class BaseballCoach implements Coach {

	private FortuneService fortuneService;

	// Define cosntrucot for dependency injection
	public BaseballCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Spend 30 minutes on batting practice";
	}

	@Override
	public String getDailyFortune() {
		// use my fortunce service

		return fortuneService.getFortune();
	}
}
