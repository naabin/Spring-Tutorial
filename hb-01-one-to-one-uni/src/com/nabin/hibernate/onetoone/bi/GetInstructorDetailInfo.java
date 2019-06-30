package com.nabin.hibernate.onetoone.bi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nabin.hibernate.entity.Instructor;
import com.nabin.hibernate.entity.InstructorDetail;

public class GetInstructorDetailInfo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			int instructorDetailId = 2;
			// get the instructor detail object
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, instructorDetailId);
			
			// print the instructor detail object
			System.out.println(instructorDetail);
			
			//print the associated instructor
			System.out.println(instructorDetail.getInstructor());
			
			
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
