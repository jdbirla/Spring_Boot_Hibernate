package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.service.TrafficFortuneService;

public class AroundDemoApp {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

		System.out.println("\n main program around demo app");

		System.out.println("Calling getFortune");

		String data = theFortuneService.getFortune();

		System.out.println("\n my Fortune dara is :" + data);

		System.out.println("Finished");

		context.close();

	}

}
