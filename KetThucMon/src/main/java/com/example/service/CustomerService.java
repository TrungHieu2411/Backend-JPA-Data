package com.example.service;

import com.example.model.Customer;

import java.util.List;

public interface CustomerService {
	 //search and show
    public List<Customer> getAllCustomer(Customer customer);
    
	public Customer findOneCustomer(int id);
    
	//CRUD
	public void addOneCustomer(Customer customer);

	public void updateOneCustomer(Customer customer);

	public void deleteOneCustomer(int id);
	
	//thong ke
	 public Long countVipCustomers();
	 
	 public Long countRegularCustomers();
	 
	 public Long countTotalCustomers();
}
