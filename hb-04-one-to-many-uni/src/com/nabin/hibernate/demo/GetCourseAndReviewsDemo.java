package com.nabin.hibernate.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nabin.hibernate.entity.Course;
import com.nabin.hibernate.entity.Instructor;
import com.nabin.hibernate.entity.InstructorDetail;
import com.nabin.hibernate.entity.Review;

public class GetCourseAndReviewsDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)
									.addAnnotatedClass(Review.class)
									.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			// start a transaction
			session.beginTransaction();
			
			//get the course
			int courseId = 10;
			Course course = session.get(Course.class, courseId);
			//print the course
			System.out.println(course);
			
			//print the course reviews
			System.out.println(course.getReviews());
			
			// commit transaction
			session.getTransaction().commit();
			
			
		} finally {
			session.close();
			factory.close();
		}
	}

}
