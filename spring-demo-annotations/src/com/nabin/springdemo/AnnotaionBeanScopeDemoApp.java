package com.nabin.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotaionBeanScopeDemoApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		TennisCoach tennisCoach = context.getBean("tennisCoach", TennisCoach.class);
		
		TennisCoach alphaCoach = context.getBean("tennisCoach", TennisCoach.class);
		
		System.out.println(tennisCoach.hashCode());
		System.out.println(alphaCoach.hashCode());
		boolean isSameObject = tennisCoach == alphaCoach;
		System.out.println("Pointing to the same object? " + isSameObject);
		
		
		context.close();
		

	}

}
