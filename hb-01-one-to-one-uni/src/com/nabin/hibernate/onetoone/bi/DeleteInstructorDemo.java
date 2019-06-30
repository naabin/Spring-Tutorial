package com.nabin.hibernate.onetoone.bi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nabin.hibernate.entity.Instructor;
import com.nabin.hibernate.entity.InstructorDetail;

public class DeleteInstructorDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			int instructorDetailId = 3;
			// get the instructor detail object
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, instructorDetailId);
			
			
			//remove the associated object reference
			//break bi-directional relationship
			
			instructorDetail.getInstructor().setInstructorDetail(null);
			
			
			session.delete(instructorDetail);
			
			
			session.getTransaction().commit();
			
		}
		catch(Exception exc) {
			exc.printStackTrace();
		}
		finally {
			session.close();
			factory.close();
		}
	}

}
