package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		// create a session
		Session session = factory.getCurrentSession();

		//
		try {

			session.beginTransaction();

			// query the student
			List<Student> theStudents = session.createQuery("from Student").getResultList();

			// display the student
			displayStudents(theStudents);

			// Query studnes
			List<Student> theStudents1 = session.createQuery("from Student s where s.lastName = 'hyd' ")
					.getResultList();

			System.out.println("studetns whose last name hyd");
			displayStudents(theStudents1);

			// query students with OR

			List<Student> theStudents2 = session
					.createQuery("from Student s where s.lastName = 'hyd' OR s.firstName='JD' ").getResultList();

			System.out.println("students with JD and hyd");
			displayStudents(theStudents2);

			// using like

			List<Student> theStudents3 = session.createQuery("from Student s where s.email like '%luv2code.com' ")
					.getResultList();

			System.out.println("students with like luv2code.com");
			displayStudents(theStudents3);

			session.getTransaction().commit();

			System.out.println("Done!");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> theStudents) {
		for (Student theStudent : theStudents) {
			System.out.println(theStudent);
		}
	}

}
