package com.luv2code.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {

	Logger myLogger = Logger.getLogger(CRMLoggingAspect.class.getName());

	@Pointcut("execution(* com.luv2code.springdemo.controller.*.*(..))")
	private void forControllerPackage() {
	}

	@Pointcut("execution(* com.luv2code.springdemo.service.*.*(..))")
	private void forServicePackage() {
	}

	@Pointcut("execution(* com.luv2code.springdemo.dao.*.*(..))")
	private void forDaoPackage() {
	}

	@Pointcut("forControllerPackage() ||forServicePackage()||forDaoPackage() ")
	private void forAppFlow() {
	}

	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
		String theMethod = theJoinPoint.getSignature().toLongString();
		myLogger.info("====>> in @before : calling method :" + theMethod);

		Object[] args = theJoinPoint.getArgs();

		for (Object arg : args) {
			myLogger.info("====> arguments : " + arg);
		}

	}

	@AfterReturning(pointcut = "forAppFlow()", returning = "theResult")
	public void afterReturning(JoinPoint theJoinPoint, Object theResult) {
   
		String theMethod = theJoinPoint.getSignature().toLongString();
		myLogger.info("====>> in @afterreturning : from method :" + theMethod);
		
		myLogger.info("====>> Result is : "+theResult);
		
	}

}
