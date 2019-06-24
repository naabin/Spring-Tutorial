package com.nabin.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SprotConfig.class);
		
		SwimCoach tennisCoach = context.getBean("swimCoach", SwimCoach.class);
		System.out.println(tennisCoach.getDailyWorkout());
		System.out.println(tennisCoach.getDailyFortune());
		System.out.println(tennisCoach.getEmail());
		System.out.println(tennisCoach.getTeam());
		
		context.close();
		
		
	}

}
