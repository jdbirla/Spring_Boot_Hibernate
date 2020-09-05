package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDempApp {

	public static void main(String[] args) {

		// read java config class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);

		// get the bean
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
	
		// call method
		System.out.println(theCoach.getDailyWorkout());

		System.out.println(theCoach.getDailyFortune());
		// close context
		context.close();
	}

}
