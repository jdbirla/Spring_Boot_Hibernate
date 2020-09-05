package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateInstructorDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();
		// create a session
		Session session = factory.getCurrentSession();

		//
		try {

			Instructor instructor = new Instructor("JD1", "Birla", "jitendra.birla21");

			InstructorDetail instructorDetail = new InstructorDetail("JD1", "luv 2 code");

			instructor.setInstructorDetail(instructorDetail);

			session.beginTransaction();
			System.out.println("Saving instructor : " + instructor);
			session.save(instructor);

			session.getTransaction().commit();

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
