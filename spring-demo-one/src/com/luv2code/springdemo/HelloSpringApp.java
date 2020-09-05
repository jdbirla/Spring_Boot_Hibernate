package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// load the spring configuaration
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// retrieve bean
		Coach theCoach = context.getBean("myCoach", Coach.class);

		// Call method of bean
		System.out.println(theCoach.getDailyWorkout());

		//new methid
		System.out.println(theCoach.getDailyFortune());
		
		// Close context
		context.close();

	}

}
