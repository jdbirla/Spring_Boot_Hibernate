package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	// @Before("execution(public void
	// com.luv2code.aopdemo.dao.AccountDAO.addAccount())")
	// @Before("execution(public void add*())")
	// @Before("execution(* add*(com.luv2code.aopdemo.Account,..))")
	// @Before("execution(* add*(..))")

	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {
	}

	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")
	private void getter() {
	}

	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")
	private void setter() {
	}

	@Pointcut("forDaoPackage() && !(getter() || setter())")
	private void forDaoPAckageNoGetterSetter() {
	}

	@Before("forDaoPAckageNoGetterSetter()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n======>>> executing @before advice on method using  pointcut");
	}

	@Before("forDaoPAckageNoGetterSetter()")
	public void performApiAnalytics() {
		System.out.println("\n======>>> performing API Analytics");
	}

}
