package com.nabin.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {
	//create an array of strings
	private String[] data = {
			"Beaware of the wolf in sheep's clothing",
			"Diligence is the mother of good luck",
			"The journey is the reward"
	};
	
	private Random myRandmom = new Random();
	
	@Override
	public String getFortune() {
		// pick a random string from the array
		int index = myRandmom.nextInt(data.length);
		
		return data[index];
	}

}
