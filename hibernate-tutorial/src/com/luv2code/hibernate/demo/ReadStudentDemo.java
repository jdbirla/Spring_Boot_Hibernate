package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		// create a session
		Session session = factory.getCurrentSession();

		//
		try {
			System.out.println("cratinf new student");
			Student student = new Student("daffy", "duck", "daffy@luv2code.com");

			session.beginTransaction();

			System.out.println("saving the student");
			System.out.println(student);

			session.save(student);

			session.getTransaction().commit();

			System.out.println("saved generated id :" + student.getId());

			// now get new session and start new transaction

			session = factory.getCurrentSession();
			session.beginTransaction();
			// get the student based on id
			System.out.println("getting student with id : " + student.getId());

			Student myStudent = session.get(Student.class, student.getId());
			System.out.println("got the student :" + myStudent);

			// commit trasaction
			session.getTransaction().commit();

			System.out.println("Done!");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}

}
