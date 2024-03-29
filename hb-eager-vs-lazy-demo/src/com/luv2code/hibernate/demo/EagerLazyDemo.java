package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class EagerLazyDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();
		// create a session
		Session session = factory.getCurrentSession();

		//
		try {
			session.beginTransaction();

			int theId = 3405309;

			Instructor instructor = session.get(Instructor.class, theId);

			System.out.println("Insructor got : " + instructor);

			session.getTransaction().commit();
			session.close();
			System.out.println("Insructo ke courses : " + instructor.getCourses());

			System.out.println("Done!");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}
	}

}
