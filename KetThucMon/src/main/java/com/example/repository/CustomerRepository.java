package com.example.repository;

import com.example.model.Customer;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	@Query("SELECT COUNT(c) FROM Customer c WHERE c.customerType = 'Vip'")
	Long countVipCustomers();

	@Query("SELECT COUNT(c) FROM Customer c WHERE c.customerType = 'Thường'")
	Long countRegularCustomers();
	
}
