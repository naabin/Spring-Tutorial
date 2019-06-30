package com.nabin.hibernate.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nabin.hibernate.entity.Course;
import com.nabin.hibernate.entity.Instructor;
import com.nabin.hibernate.entity.InstructorDetail;
import com.nabin.hibernate.entity.Review;

public class CreateCourseAndReviewsDemo {

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
			
			//create course
			Course course = new Course("Python");
			
			Review review1 = new Review("It's a dynamic language and does a lots of heavy work for you.");
			Review review2 = new Review("It's web framework django.");
			Review review3 = new Review("Python is haevily used on data science.");
			//add some views
			course.addReview(review1);
			course.addReview(review2);
			course.addReview(review3);
			
			// save the course
			session.save(course);

			// commit transaction
			session.getTransaction().commit();
			
			
		} finally {
			session.close();
			factory.close();
		}
	}

}
