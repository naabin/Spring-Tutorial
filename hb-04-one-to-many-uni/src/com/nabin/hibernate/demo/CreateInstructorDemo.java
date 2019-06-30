package com.nabin.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nabin.hibernate.entity.Course;
import com.nabin.hibernate.entity.Instructor;
import com.nabin.hibernate.entity.InstructorDetail;

public class CreateInstructorDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)
									.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			//create the objects
			Instructor instructor = new Instructor("Gobin", "Karki", "gobin@outlook.com");
			
			InstructorDetail instructorDetail = new InstructorDetail("youtube.com/gobin", "Gym");
			


			
			// associate the objects
			instructor.setInstructorDetail(instructorDetail);
			
			
			//begin transaction
			session.beginTransaction();
			
			//save the instructor
			//Note: this will also save the details object
			//because of CascadeType.ALL
			System.out.println("Saving instructor: " + instructor);
			session.save(instructor);

			// commit transaction
			session.getTransaction().commit();
			System.out.println("Instructor object created.");
			
		} finally {
			session.close();
			factory.close();
		}
	}

}
