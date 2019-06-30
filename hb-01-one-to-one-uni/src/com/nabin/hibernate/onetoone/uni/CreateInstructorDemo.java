package com.nabin.hibernate.onetoone.uni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nabin.hibernate.entity.Instructor;
import com.nabin.hibernate.entity.InstructorDetail;

public class CreateInstructorDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			//create the objects
			Instructor instructor = new Instructor("Nabin", "Karki", "naabin@outlook.com");
			
			InstructorDetail instructorDetail = new InstructorDetail("youtube.com/nabin", "Eat");
			
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
			factory.close();
		}
	}

}
