package com.luv2code.springboot.thymeleafdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springboot.thymeleafdemo.dao.EmployeeRepository;
import com.luv2code.springboot.thymeleafdemo.entity.Employee;

@Service
public class EmpoloyeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;

	@Autowired
	public EmpoloyeeServiceImpl(EmployeeRepository theEmployeeRepository) {
		employeeRepository = theEmployeeRepository;
	}

	@Override
	public List<Employee> findAll() {

		return employeeRepository.findAllByOrderByLastNameAsc();
	}

	@Override
	public Employee findById(int theId) {
		// TODO Auto-generated method stub
		Optional<Employee> result = employeeRepository.findById(theId);

		Employee theEmployee = null;
		if (result.isPresent()) {
			theEmployee = result.get();
		} else {
			throw new RuntimeException("Didn't find employee id =" + theId);
		}
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		// TODO Auto-generated method stub
		employeeRepository.save(theEmployee);
	}

	@Override
	public void deleteById(int theId) {
		employeeRepository.deleteById(theId);

	}

}
