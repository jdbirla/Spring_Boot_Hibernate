package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MemberShipDAO;

public class MainDemoApp {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		Account account = new Account();
		theAccountDAO.addAccount(account, true);

		theAccountDAO.setName("foobar");
		theAccountDAO.setServiceName("silver");

		String name = theAccountDAO.getName();
		String serviceName = theAccountDAO.getServiceName();

		MemberShipDAO theMemberDAO = context.getBean("memberShipDAO", MemberShipDAO.class);

		theMemberDAO.addSillyMember();
		context.close();

	}

}
