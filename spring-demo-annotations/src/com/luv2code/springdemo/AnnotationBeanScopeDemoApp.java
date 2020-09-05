package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {

		// read spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// get the bean
		Coach theCoach = context.getBean("tennisCoach", Coach.class);

		Coach alphaCoach = context.getBean("tennisCoach", Coach.class);
		// call method
		boolean result = theCoach == alphaCoach;

		System.out.println("poiting to the same object : " + result);
		System.out.println("the coach location: " + theCoach);
		System.out.println("Alpha coach location : " + alphaCoach);
		// close context
		context.close();

	}

}
