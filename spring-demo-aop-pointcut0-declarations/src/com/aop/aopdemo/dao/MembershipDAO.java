package com.aop.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	
	public void addMember() {
		System.out.println(getClass()+ ": Adding a membership account");
	}
	
	public void goToSleep() {
		System.out.println(getClass() + ": I'm going to sleep");
	}
}
