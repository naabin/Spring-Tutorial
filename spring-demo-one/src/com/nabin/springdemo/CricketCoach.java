package com.nabin.springdemo;

public class CricketCoach implements Coach {

	private FortuneService fortuneService;

	private String emailAddress;
	private String team;

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public String getTeam() {
		return team;
	}

	// create a no-argument constructor
	public CricketCoach() {
	}

	public void setFortuneService(FortuneService fortuneServie) {
		this.fortuneService = fortuneServie;
	}

	@Override
	public String getDailyWorkout() {
		return "Practice fast bowling for 15 minutes.";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
