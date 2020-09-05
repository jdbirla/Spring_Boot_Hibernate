package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MemberShipDAO;

public class AfterThrowingDemoApp {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

		List<Account> theAccounts = null;
		
		try {
			boolean tripWire = true;
			theAccountDAO.findAccounts(tripWire);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("main program cought execption :"+e);
		}
		

		System.out.println("main program for after throwing :" + theAccounts);
		System.out.println("============");
		System.out.println("\n");

		context.close();

	}

}
