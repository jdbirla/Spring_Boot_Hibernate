package com.luv2code.aopdemo.aspect;


import org.aspectj.lang.JoinPoint;
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

	

	@Before("com.luv2code.aopdemo.aspect.LuvAopExpression.forDaoPAckageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		System.out.println("\n======>>> executing @before advice on method using  pointcut");
	
	//display method signature and args
		MethodSignature methodSig =  (MethodSignature)theJoinPoint.getSignature();
		System.out.println("Method :"+methodSig);

		Object[] args =  theJoinPoint.getArgs();

		for(Object arg : args)
		{
			System.out.println(arg);
			
			if(arg instanceof Account)
			{
				Account theAcc =  (Account) arg;
				
				System.out.println("Account Name :"+theAcc.getName());
				System.out.println("Account Level :"+theAcc.getLevel());
				
			}
		}
		
	}

	
	
}
