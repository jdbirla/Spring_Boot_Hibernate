package com.luv2code.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

	private Logger myLogger = Logger.getLogger(MyDemoLoggingAspect.class.getName());

	@Around("execution(* com.luv2code.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoin) throws Throwable {
		String method = theProceedingJoin.getSignature().toShortString();
		myLogger.info("\n ====>>> executing @around  on method :" + method);

		long begin = System.currentTimeMillis();

		Object result = theProceedingJoin.proceed();

		long end = System.currentTimeMillis();

		long duration = end - begin;
		myLogger.info("\n ====> Duration :" + duration / 1000.0 + " seconds");

		return result;
	}

	@After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint theJointPoint) {

		String method = theJointPoint.getSignature().toShortString();
		myLogger.info("\n ====>>> executing @after finally  on method :" + method);

	}

	@AfterThrowing(pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))", throwing = "theExe")
	public void afterThrowingFindAccountsAdvice(JoinPoint theJointPoint, Throwable theExe) {
		String method = theJointPoint.getSignature().toShortString();
		myLogger.info("\n ====>>> executing @after throwing  on method :" + method);

		myLogger.info("\n ==>>> The execpetion is :" + theExe);

	}

	@AfterReturning(pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))", returning = "result")
	public void afterReturningFindAccountAdvice(JoinPoint theJoinPoint, List<Account> result) {

		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n ====>>> executing @after returning  on method :" + method);

		myLogger.info("\n ====>>> Result is :" + result);
		myLogger.info("\n");

		// lets post process the data let's modify it

		// conert the name to upppercase
		convertAccountNamesToUpperCase(result);
		myLogger.info("\n ====>>> Result is after conversion :" + result);
		myLogger.info("\n");

	}

	private void convertAccountNamesToUpperCase(List<Account> result) {

		// loop throigh accounts and get the upper case and update the account object
		for (Account tempacc : result) {
			String theUpperName = tempacc.getName().toUpperCase();
			tempacc.setName(theUpperName);

		}
	}

	@Before("com.luv2code.aopdemo.aspect.LuvAopExpression.forDaoPAckageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		myLogger.info("\n======>>> executing @before advice on method using  pointcut");

		// display method signature and args
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		myLogger.info("Method :" + methodSig);

		Object[] args = theJoinPoint.getArgs();

		for (Object arg : args) {
			myLogger.info(arg.toString());

			if (arg instanceof Account) {
				Account theAcc = (Account) arg;

				myLogger.info("Account Name :" + theAcc.getName());
				myLogger.info("Account Level :" + theAcc.getLevel());

			}
		}

	}

}
