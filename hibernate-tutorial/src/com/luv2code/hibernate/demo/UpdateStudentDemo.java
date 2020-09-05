package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		// create a session
		Session session = factory.getCurrentSession();

		//
		try {

			int studenId = 3405292;
			

			session = factory.getCurrentSession();
			session.beginTransaction();
			// get the student based on id
			System.out.println("getting student with id : " + studenId);

			Student myStudent = session.get(Student.class, studenId);
			System.out.println("got the student :" + myStudent);

			System.out.println("updating the studen");
			myStudent.setLastName("hyd");

			myStudent.setEmail("jitendra.birla21@gmail.com");
			// commit trasaction
			session.getTransaction().commit();
			
			
			//NEw code
			
			session =  factory.getCurrentSession();
			session.beginTransaction();
			
			//update email for all
			
			System.out.println("email update fro all");
			
			session.createQuery(" update Student set email='jitendra.birla21@gmail.com' ").executeUpdate();
			
			
			
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
