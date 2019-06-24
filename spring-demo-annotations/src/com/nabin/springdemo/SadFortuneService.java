package com.nabin.springdemo;

public class SadFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Today is sad day";
	}

}
