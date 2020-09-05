package com.luv2code.springboot.cruddemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springboot.cruddemo.dao.EmployeeDAO;
import com.luv2code.springboot.cruddemo.entity.Employee;

@Service
@Transactional
public class EmpoloyeeServiceImpl implements EmployeeService {

	private EmployeeDAO employeedao;

	@Autowired
	public EmpoloyeeServiceImpl(@Qualifier("employeeDAOHibernateImpl") EmployeeDAO theEmployeedao) {
		employeedao = theEmployeedao;
	}

	@Override
	public List<Employee> findAll() {

		return employeedao.findAll();
	}

	@Override
	public Employee findById(int theId) {
		// TODO Auto-generated method stub
		return employeedao.findById(theId);
	}

	@Override
	public void save(Employee theEmployee) {
		// TODO Auto-generated method stub
		employeedao.save(theEmployee);
	}

	@Override
	public void deleteById(int theId) {
		employeedao.deleteById(theId);

	}

}
