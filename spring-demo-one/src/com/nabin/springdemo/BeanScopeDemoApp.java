package com.nabin.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		
		Coach theCoach = context.getBean("myCoach", Coach.class);
		
		Coach alphaCoach = context.getBean("myCoach", Coach.class);
		
		System.out.println(theCoach == alphaCoach);
		
		System.out.println("Memory location for theCoach " + theCoach.hashCode() );
		
		System.out.println("Memory location for alphaCoach " +alphaCoach.hashCode() );
		
		
		
		
		context.close();
		
	}

}
