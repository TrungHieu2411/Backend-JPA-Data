package com.example.service;

import com.example.model.Employee;

import java.util.List;

public interface EmployeeService {
	 //search and show
    public List<Employee> getAllEmployee(Employee employee);
    
	public Employee findOneEmployee(int id);
	//CRUD
	public void addOneEmployee(Employee employee);

	public void updateOneEmployee(Employee employee);

	public void deleteOneEmployee(int id);
	
	//thong ke
	 public Long countTotalEmployees();
}
