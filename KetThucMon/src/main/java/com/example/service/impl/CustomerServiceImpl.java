package com.example.service.impl;

import com.example.model.Customer;
import com.example.repository.CustomerRepository;
import com.example.service.CustomerService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomer(Customer customer) {
        return customerRepository.findAll();
    }
    
    @Override
    public Customer findOneCustomer(int id) {
        return customerRepository.findById(id).orElse(null);
    }
    
    @Override
    public void addOneCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void updateOneCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void deleteOneCustomer(int id) {
        customerRepository.deleteById(id);
    }

    public Long countVipCustomers() {
        return customerRepository.countVipCustomers();
    }

    public Long countRegularCustomers() {
        return customerRepository.countRegularCustomers();
    }

	@Override
	public Long countTotalCustomers() {
		return customerRepository.count();
	}

}
