package com.aop.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLogginAspect {
	// this is where we add all of our related advice for logging
	
	@Pointcut("execution(public * com.aop.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {};
	
	// let's start with and @Before advice
	@Before("forDaoPackage()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n=======> Executing @Before advice on addAccount");
	}
	
	
	@Before("forDaoPackage()")
	public void performApiAnalytics() {
		System.out.println("========> Performing API analytics");
	}
}
