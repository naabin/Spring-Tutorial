package com.nabin.hibernate.crud;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nabin.hibernate.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//retrieve the students objects
			List<Student> resultList = session.createQuery("from Student").getResultList();
			
			//Query student
			List<Student> resultList2 = session.createQuery("from Student s where s.lastName='Karki'").getResultList();
			
			List<Student> resultList3 = session.createQuery("from Student s where s.email LIKE '%gmail.com'").getResultList();
			
			
			List<Student> resultList4 = session.createQuery("from Student s where s.firstName='Nabin' OR s.lastName='Karki'").getResultList();
			
			for(Student student: resultList4) {
				System.out.println(student);
			}
			
		
			
			session.getTransaction().commit();
			
		} finally {
			factory.close();
		}
	}

}
