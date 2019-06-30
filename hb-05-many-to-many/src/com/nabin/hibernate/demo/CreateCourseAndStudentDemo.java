package com.nabin.hibernate.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nabin.hibernate.entity.Course;
import com.nabin.hibernate.entity.Instructor;
import com.nabin.hibernate.entity.InstructorDetail;
import com.nabin.hibernate.entity.Review;
import com.nabin.hibernate.entity.Student;

public class CreateCourseAndStudentDemo {

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
			
			Course course = new Course("Java Spring");
			//saving the course 
			session.save(course);
			
			//creating students
			Student student = new Student("John", "Doe", "john@email.com");
			Student student2 = new Student("Tom", "Cruise", "tom@email.com");
			
			//adding student to the course
			course.addStudent(student);
			course.addStudent(student2);
			// saving the students
			session.save(student);
			session.save(student2);
			
			System.out.println(course.getStudents());
			// commit transaction
			session.getTransaction().commit();
			
			
		} finally {
			session.close();
			factory.close();
		}
	}

}
