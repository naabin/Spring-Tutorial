package com.aop.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aop.aopdemo.dao.AccountDao;
import com.aop.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		//read spring configuration java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		// get the bean from the spring container
		AccountDao theAccountDao = context.getBean(AccountDao.class);
		
		// get membership bean from spring container
		MembershipDAO membershipDAO = context.getBean(MembershipDAO.class);
		
		// call the membership dao method
		membershipDAO.addMember();
		membershipDAO.goToSleep();
		
		//call the business method
		theAccountDao.addAccount(new Account(), true);
		theAccountDao.doWork();
		// close the context
		context.close();
		
	}

}
