package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class DeleteDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		// create a session
		Session session = factory.getCurrentSession();

		//
		try {

			session.beginTransaction();

			int theID = 3405290;

			Instructor intrucotr = session.get(Instructor.class, theID);

			System.out.println("fouund the ins :" + intrucotr);

			if (intrucotr != null) {
				// it will delete all cascade objects
				session.delete(intrucotr);
			}

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
