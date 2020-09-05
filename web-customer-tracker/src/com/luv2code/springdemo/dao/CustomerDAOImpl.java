package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	// need to inject session factory

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {

		// get the current hibernate session

		Session currentSession = sessionFactory.getCurrentSession();

		// creat query
		Query<Customer> theQuery = currentSession.createQuery(" from Customer order by lastName ", Customer.class);

		// get the result
		List<Customer> customers = theQuery.getResultList();

		// retunr list of customer

		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {

		Session currentSession = sessionFactory.getCurrentSession();

		// currentSession.save(theCustomer);
		currentSession.saveOrUpdate(theCustomer);

	}

	@Override
	public Customer getCustomer(int theId) {

		Session currentSession = sessionFactory.getCurrentSession();

		Customer customer = currentSession.get(Customer.class, theId);

		return customer;

	}

	@Override
	public void deleteCustomer(int theId) {
		// TODO Auto-generated method stub

		Session currentSession = sessionFactory.getCurrentSession();

		Query theQuery = currentSession.createQuery(" delete from Customer where id =: theCustomerId");
		theQuery.setParameter("theCustomerId", theId);
		theQuery.executeUpdate();
	}

}
