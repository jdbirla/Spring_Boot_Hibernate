package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDAO {

	private String name;
	private String serviceName;

	public void addAccount(Account theAccount, boolean flag) {
		System.out.println(getClass() + " :  DOING my DB WORK :  ADDING AN ACCOUNT");
	}

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

}
