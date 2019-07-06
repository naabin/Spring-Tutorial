package com.nabin.springdemo;

public class HappyFotuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Today is your lucky day.";
	}

}
