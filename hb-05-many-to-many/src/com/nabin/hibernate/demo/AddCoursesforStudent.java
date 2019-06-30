package com.nabin.hibernate.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nabin.hibernate.entity.Course;
import com.nabin.hibernate.entity.Instructor;
import com.nabin.hibernate.entity.InstructorDetail;
import com.nabin.hibernate.entity.Review;
import com.nabin.hibernate.entity.Student;

public class AddCoursesforStudent {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)
									.addAnnotatedClass(Review.class)
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			// start a transaction
			session.beginTransaction();
			
			// get the student john from database
			Student student = session.get(Student.class, 1);
			System.out.println(student.getCourses());
			System.out.println();
			
			// create more courses
			Course course = new Course("Database management sytstem.");
			Course course2 = new Course("Web development");

		
			// add student to courses
			student.addCourse(course);
			student.addCourse(course2);
			
			// save the courses
			session.save(course);
			session.save(course2);
			// commit transaction
			session.getTransaction().commit();
			
			
		} finally {
			session.close();
			factory.close();
		}
	}

}
