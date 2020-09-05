package com.luv2code.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDAO {

	private String name;
	private String serviceName;

	public String getName() {
		System.out.println(getClass() + " : getname");

		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() + " : setName");

		this.name = name;
	}

	public String getServiceName() {
		System.out.println(getClass() + " : getServiceName");

		return serviceName;
	}

	public void setServiceName(String serviceName) {
		System.out.println(getClass() + " : setServiceName");

		this.serviceName = serviceName;
	}

	public void addAccount(Account theAccount, boolean flag) {
		System.out.println(getClass() + " :  DOING my DB WORK :  ADDING AN ACCOUNT");
	}

	public List<Account> findAccounts(boolean tripWire) {

		if (tripWire) {
			throw new RuntimeException("No soup for you");

		}

		List<Account> myAccounts = new ArrayList<Account>();

		Account temp1 = new Account("john", "silver");
		Account temp2 = new Account("john1", "silver1");
		Account temp3 = new Account("john2", "silver2");

		myAccounts.add(temp1);
		myAccounts.add(temp2);
		myAccounts.add(temp3);
		return myAccounts;
	}

}
