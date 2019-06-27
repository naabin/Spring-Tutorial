package com.nabin.hibernate.test;

import java.sql.Connection;
import java.sql.DriverManager;

public class HibernateConnectionTest {

	public static void main(String[] args) {
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimezone=UTC";
		String user = "hbstudent";
		String password = "hbstudent";
		
		try {
			System.out.println("Connecting to jdbc" + jdbcUrl);
			Connection myConn = DriverManager.getConnection(jdbcUrl, user, password);
			
			System.out.println("Connection successful.\n\n" + myConn);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
