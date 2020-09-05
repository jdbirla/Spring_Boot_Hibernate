package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDAO {
	public void addAccount(Account theAccount,boolean flag) {
		System.out.println(getClass() + " :  DOING my DB WORK :  ADDING AN ACCOUNT");
	}
	
	
}
