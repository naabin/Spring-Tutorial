package com.nabin.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {
	
	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService theFortuneService;
	
	public TennisCoach() {
		
	}
	
	
	//Constructor injection
	//	@Autowired
	//	public TennisCoach(FortuneService theFortuneService) {
	//	this.theFortuneService = theFortuneService;
	//	}
	
	//Method injection
	/*@Autowired
	public void setTheFortuneService(FortuneService theFortuneService) {
		this.theFortuneService = theFortuneService;
	}
	*/
	
	//define my init method
	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println(">> Tennis Coach: inside of doMyStartupStuff");
	}
	
	
	@PreDestroy
	public void doMyCleanupStuff() {
		System.out.println(">> Tennis Coach: inside of doMyCleanupStuff");
	}
	
	
	//define my destroy method


	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return theFortuneService.getFortune();
	}

}
