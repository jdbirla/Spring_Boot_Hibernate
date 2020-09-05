package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDempApp {

	public static void main(String[] args) {

		// read java config class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);

		// get the bean
		SwimCoach theCoach = context.getBean("swimCoach", SwimCoach.class);
	
		// call method
		System.out.println(theCoach.getDailyWorkout());

		System.out.println(theCoach.getDailyFortune());
		
		System.out.println("email: "+theCoach.getEmail());
		
		System.out.println("team : "+theCoach.getTeam());
		
		// close context
		context.close();
	}

}
