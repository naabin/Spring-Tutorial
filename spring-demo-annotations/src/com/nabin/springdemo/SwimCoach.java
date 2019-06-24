package com.nabin.springdemo;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach {
	
	private FortuneService fortuneService;
	@Value("${foo.email}")
	private String email;
	@Value("${foo.team}")
	private String team;
	
	public SwimCoach() {
	}
	

	public SwimCoach(FortuneService fortuneService) {
		
		this.fortuneService = fortuneService;
	}
	

	public String getEmail() {
		return email;
	}


	public String getTeam() {
		return team;
	}


	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Swim 1000 meters as a warm up.";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
