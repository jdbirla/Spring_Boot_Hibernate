package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MemberShipDAO {
	public boolean addSillyMember() {
		System.out.println(getClass() + " :  DOING my DB WORK :  Adding memeber Ship card");
	  return false;
	}
}
