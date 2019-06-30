package com.nabin.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nabin.hibernate.entity.Course;
import com.nabin.hibernate.entity.Instructor;
import com.nabin.hibernate.entity.InstructorDetail;

public class EagerLazyDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)
									.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			// start a transaction
			session.beginTransaction();
			
			Instructor instructor = session.get(Instructor.class, 1);
			
			
			System.out.println("Courses: love2Code" + instructor.getCourses());
			

			
			System.out.println("Instructor: " + instructor);
			
			// get courses for the instructor
			

			// commit transaction
			session.getTransaction().commit();
			session.close();
			System.out.println("Session is now closed\n\n\n\n\n");
			System.out.println("Courses: love2Code" + instructor.getCourses());
			
			
		} finally {
			session.close();
			factory.close();
		}
	}

}
