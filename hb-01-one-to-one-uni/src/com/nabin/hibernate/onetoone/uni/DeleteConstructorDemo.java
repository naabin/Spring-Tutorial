package com.nabin.hibernate.onetoone.uni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nabin.hibernate.entity.Instructor;
import com.nabin.hibernate.entity.InstructorDetail;

public class DeleteConstructorDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			//create the objects
			int instructorId = 1;
			
			// associate the objects
			
			
			//begin transaction
			session.beginTransaction();
			Instructor instructor = session.get(Instructor.class, instructorId);
			
			//save the instructor
			//Note: this will also save the details object
			//because of CascadeType.ALL
			System.out.println("Deleting instructor: " + instructor);
			if(instructor != null) {
				session.delete(instructor);
			}

			// commit transaction
			session.getTransaction().commit();
			System.out.println("Object deleted");
			
		} finally {
			factory.close();
		}
	}

}
