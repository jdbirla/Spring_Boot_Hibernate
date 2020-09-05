package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LuvAopExpression {
	// @Before("execution(public void
		// com.luv2code.aopdemo.dao.AccountDAO.addAccount())")
		// @Before("execution(public void add*())")
		// @Before("execution(* add*(com.luv2code.aopdemo.Account,..))")
		// @Before("execution(* add*(..))")

		@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
		public void forDaoPackage() {
		}

		@Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")
		public void getter() {
		}

		@Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")
		public void setter() {
		}

		@Pointcut("forDaoPackage() && !(getter() || setter())")
		public void forDaoPAckageNoGetterSetter() {
		}
}
