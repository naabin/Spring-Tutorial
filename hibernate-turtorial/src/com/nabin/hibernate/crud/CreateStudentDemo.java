package com.nabin.hibernate.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nabin.hibernate.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("Creating student");
			session = factory.getCurrentSession();
			
			//begin transaction
			session.beginTransaction();
			
			Student student = new Student("Manish", "Khatrio", "manish@email.com");
			
			session.save(student);
			
			session.getTransaction().commit();
			System.out.println("Student object created.");
			
		} finally {
			factory.close();
		}
	}

}
