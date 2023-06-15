package com.example.service.impl;

import com.example.model.Employee;
import com.example.repository.EmployeeRepository;
import com.example.service.EmployeeService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getAllEmployee(Employee employee) {
		return employeeRepository.findAll();
	}

	@Override
	public Employee findOneEmployee(int id) {
		return employeeRepository.findById(id).orElse(null);
	}
	
	@Override
	public void addOneEmployee(Employee employee) {
		employeeRepository.save(employee);
	}

	@Override
	public void updateOneEmployee(Employee employee) {
		employeeRepository.save(employee);
	}

	@Override
	public void deleteOneEmployee(int id) {
		employeeRepository.deleteById(id);
	}

	@Override
	public Long countTotalEmployees() {
		return employeeRepository.count();
	}
	
}
