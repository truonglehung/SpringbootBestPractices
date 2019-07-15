package com.vsolu.restfuljpa.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.vsolu.restfuljpa.repository.EmployeeRepository;

public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
}
