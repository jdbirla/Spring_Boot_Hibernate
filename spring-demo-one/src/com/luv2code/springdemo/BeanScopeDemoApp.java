package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");

		Coach theCoach = context.getBean("myCoach", Coach.class);
		Coach alphaCoach = context.getBean("myCoach", Coach.class);

		// check if they are same bean
		boolean res = theCoach == alphaCoach;
		System.out.println("\npointing to the same object : " + res);
		System.out.println("\n Memory location for the coach : " + theCoach);
		System.out.println("\n Memory location for the alpha coach  : " + alphaCoach);

		context.close();
	}

}
