package com.aop.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.aop.aopdemo.Account;

@Component
public class AccountDao {

	public void addAccount(Account account, boolean vipFlag) {
		System.out.println(getClass() + ": Doing my DB work: adding an account");
	}
	
	public boolean doWork() {
		System.out.println(getClass() + ": doWork()");
		return false;
	}
}
