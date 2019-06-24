package com.nabin.springdemo;

public class TrackCoach implements Coach {
	
	private FortuneService theFortuneService;
	
	public TrackCoach() {
		
	}
	 
	public TrackCoach(FortuneService theFortuneService) {
		this.theFortuneService = theFortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Run a hard 5K";
	}

	@Override
	public String getDailyFortune() {
		return "Just do it " + theFortuneService.getFortune();
	}
	
	// add an init method
	public void doMyStartupStuff() {
		System.out.println("TrackCoach: inside method doMyStratupStuff");
	}
	

	//add a destroy method
	public void doMyCleanupStuff() {
		System.out.println("TrackCoach: inside method doMyCleanStuff");
	}
}
