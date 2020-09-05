package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		// create a session
		Session session = factory.getCurrentSession();

		//
		try {

			int studenId = 3405296;

			session = factory.getCurrentSession();
			session.beginTransaction();
			// get the student based on id
			System.out.println("getting student with id : " + studenId);

			Student myStudent = session.get(Student.class, studenId);

			// Delete the student
			/*
			 * System.out.println("Deleting the student "); session.delete(myStudent);
			 */

			// HQL
			System.out.println("Deleting the student = 2");
			session.createQuery("Delete from Student  where id= '3405295' ").executeUpdate();

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
