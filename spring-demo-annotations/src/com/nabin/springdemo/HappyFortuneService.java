package com.nabin.springdemo;

import org.springframework.stereotype.Component;

@Component
public class HappyFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Today is very fortunate day for all people.";
	}

}
