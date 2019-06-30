package com.nabin.hibernate.demo;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.nabin.hibernate.entity.Course;
import com.nabin.hibernate.entity.Instructor;
import com.nabin.hibernate.entity.InstructorDetail;

public class FetchJoinDemo {

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
			
			
			
			//Hibernate query with HQL
			Query<Instructor> createQuery = 
					session.createQuery("select i from Instructor i " + "JOIN FETCH i.courses " + "where i.id=:instructorId", 
					Instructor.class);
			// set parameter on query
			createQuery.setParameter("instructorId", 1);
			
			//execute query and get instructor
			Instructor instructor = createQuery.getSingleResult();
			System.out.println("Instructor: " + instructor);
			
			// get courses for the instructor
			

			// commit transaction
			session.getTransaction().commit();
			session.close();
			System.out.println("Session is now closed\n\n");
			System.out.println("Courses: love2Code" + instructor.getCourses());
			
			
		} finally {
			session.close();
			factory.close();
		}
	}

}
