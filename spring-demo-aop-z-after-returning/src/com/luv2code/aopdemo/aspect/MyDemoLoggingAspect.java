package com.luv2code.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
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

	@AfterThrowing(pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))", throwing = "theExe")
	public void afterThrowingFindAccountsAdvice(JoinPoint theJointPoint, Throwable theExe) {
		String method = theJointPoint.getSignature().toShortString();
		System.out.println("\n ====>>> executing @after throwing  on method :" + method);

		System.out.println("\n ==>>> The execpetion is :" + theExe);

	}

	@AfterReturning(pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))", returning = "result")
	public void afterReturningFindAccountAdvice(JoinPoint theJoinPoint, List<Account> result) {

		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n ====>>> executing @after returning  on method :" + method);

		System.out.println("\n ====>>> Result is :" + result);
		System.out.println("\n");

		// lets post process the data let's modify it

		// conert the name to upppercase
		convertAccountNamesToUpperCase(result);
		System.out.println("\n ====>>> Result is after conversion :" + result);
		System.out.println("\n");

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
		System.out.println("\n======>>> executing @before advice on method using  pointcut");

		// display method signature and args
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		System.out.println("Method :" + methodSig);

		Object[] args = theJoinPoint.getArgs();

		for (Object arg : args) {
			System.out.println(arg);

			if (arg instanceof Account) {
				Account theAcc = (Account) arg;

				System.out.println("Account Name :" + theAcc.getName());
				System.out.println("Account Level :" + theAcc.getLevel());

			}
		}

	}

}
