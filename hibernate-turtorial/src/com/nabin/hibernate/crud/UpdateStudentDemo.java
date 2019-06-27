package com.nabin.hibernate.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nabin.hibernate.entity.Student;

public class UpdateStudentDemo {

	

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			int studentId = 1;
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			Student student = session.get(Student.class, studentId);
			
			student.setLastName("Karki");
			
			session.getTransaction().commit();
			
		} finally {
			factory.close();
		}
	}

}
