package com.luv2code.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component("thatSillyCoach")
@Component
//@Scope("prototype")
public class TennisCoach implements Coach {

	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;

	/*
	 * @Autowired public TennisCoach(FortuneService fortuneService) {
	 * this.fortuneService = fortuneService; }
	 */

	public TennisCoach() {
		System.out.println("inside default contructor");
	}
	
	//Define my init method
	@PostConstruct
	public void doMyStartup()
	{
	System.out.println("Tenni coach : do my startup");	
	}
	//Define destroy
	@PreDestroy
	public void doMyDestroy()
	{
		System.out.println("Tenni coach : do my destroy");	

	}

	@Override
	public String getDailyWorkout() {

		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

	//Defin setter method for injectig fortune service
	/*
	 * @Autowired public void setFortuneService(FortuneService fortuneService) {
	 * System.out.println("Inside Tennis Coach setFortuneservice");
	 * this.fortuneService = fortuneService; }
	 */
	
	//Defin any method for injecting fortune service with auto wireing
	/*
	 * @Autowired public void doSomeCrazyStuff(FortuneService fortuneService ) {
	 * System.out.println("Inside Tennis Coach doSomeCrazyStuff");
	 * this.fortuneService = fortuneService; }
	 */
	
	

}
