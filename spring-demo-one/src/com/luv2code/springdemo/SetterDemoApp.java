package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {

	public static void main(String[] args) {

		
		// load the spring configuaration
				ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

				// retrieve bean
				CricketCoach theCoach = context.getBean("myCricketCoach", CricketCoach.class);

				// Call method of bean
		
		  System.out.println(theCoach.getDailyWorkout());
		 
				//new methid
				System.out.println(theCoach.getDailyFortune());
				
				System.out.println(theCoach.getEmailAddress());
				System.out.println(theCoach.getTeam());
				// Close context
				context.close();
	}

}
