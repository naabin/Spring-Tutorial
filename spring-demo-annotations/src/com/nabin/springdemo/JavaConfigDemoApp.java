package com.nabin.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class JavaConfigDemoApp {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SprotConfig.class);
		
		TennisCoach tennisCoach = context.getBean("tennisCoach", TennisCoach.class);
		System.out.println(tennisCoach.getDailyWorkout());
		System.out.println(tennisCoach.getDailyFortune());
		
		context.close();
		
		
	}

}
