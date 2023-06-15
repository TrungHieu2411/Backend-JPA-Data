package com.example.controller;

import com.example.model.Customer;
import com.example.repository.CustomerRepository;
import com.example.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private CustomerRepository customerRepository;

	@GetMapping("/list")
	public String getCustomerList(Model model) {
		Customer customer = new Customer();
		List<Customer> customerList = customerService.getAllCustomer(customer);
		model.addAttribute("customerList", customerList);
		return "customer/customer_list";
	}

	@GetMapping("/delete/{id}")
	public String deleteCustomer(@PathVariable("id") int id) {
		customerService.deleteOneCustomer(id);
		return "redirect:/customer/list";
	}

	@GetMapping(value = { "/detail", "/detail/", "/detail/{id}" })
	public String detailCustomer(@PathVariable(value = "id", required = false) Integer id, Model model) {
		Customer customer = new Customer();
		if (id != null) {
			customer = customerService.findOneCustomer(id);
		}
		model.addAttribute("customer", customer);
		return "customer/customer_form";
	}

	@PostMapping(value = "/detail", params = "create")
	public String createCustomer(@ModelAttribute("customer") Customer customer, Model model) {
		customerService.addOneCustomer(customer);
		model.addAttribute("message", "Customer created successfully");
		return "redirect:/customer/list";
	}

	@PostMapping(value = "/detail", params = "update")
	public String updateCustomer(@ModelAttribute("customer") Customer customer, Model model) {
		customerService.updateOneCustomer(customer);
		model.addAttribute("message", "Customer updated successfully");
		return "redirect:/customer/list";
	}
	
}
