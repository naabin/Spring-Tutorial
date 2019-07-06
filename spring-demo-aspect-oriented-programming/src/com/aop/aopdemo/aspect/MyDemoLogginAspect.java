package com.aop.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLogginAspect {
	// this is where we add all of our related advices for loggin
	
	// let's start with and @Before advice
	
	@Before("execution(public * com.aop.aopdemo.dao.*.*(..))")
	public void beforeAddAccountAdvice() {
		System.out.println("\n=======> Executing @Before advice on addAccount");
	}
}
