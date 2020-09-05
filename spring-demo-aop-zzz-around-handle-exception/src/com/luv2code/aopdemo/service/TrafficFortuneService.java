package com.luv2code.aopdemo.service;

import java.util.concurrent.TimeUnit;

import javax.management.RuntimeErrorException;

import org.springframework.stereotype.Component;

@Component
public class TrafficFortuneService {

	public String getFortune() {
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "Expect hevy trafic this morning";
	}

	public String getFortune(boolean tripWire) {

		if (tripWire) {
			throw new RuntimeException("major accident  hiway is closed");

		}

		return getFortune();
	}
}
