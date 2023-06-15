package com.example.restcontroller;

import com.example.model.Customer;
import com.example.service.CustomerService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerRestController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public ResponseEntity<List<Customer>> getCustomerList() {
        List<Customer> customerList = customerService.getAllCustomer(null);
        return ResponseEntity.ok(customerList);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable("id") int id) {
        customerService.deleteOneCustomer(id);
        return ResponseEntity.ok("Customer deleted successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("id") int id) {
        Customer customer = customerService.findOneCustomer(id);
        if (customer != null) {
            return ResponseEntity.ok(customer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/create")
    public ResponseEntity<String> createCustomer(@RequestBody @Valid Customer customer, BindingResult result) {
        if (result.hasErrors()) {
            StringBuilder devErrorMsg = new StringBuilder();
            List<ObjectError> allErrors = result.getAllErrors();
            for (ObjectError objectError : allErrors) {
                devErrorMsg.append(objectError.getDefaultMessage()).append("\n");
            }
            return ResponseEntity.badRequest().body("Invalid Customer data received: " + devErrorMsg.toString());
        }
        customerService.addOneCustomer(customer);
        return ResponseEntity.ok("Customer created successfully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateCustomer(@PathVariable("id") int id, @RequestBody @Valid Customer customer,
            BindingResult result) {
        if (result.hasErrors()) {
            StringBuilder devErrorMsg = new StringBuilder();
            List<ObjectError> allErrors = result.getAllErrors();
            for (ObjectError objectError : allErrors) {
                devErrorMsg.append(objectError.getDefaultMessage()).append("\n");
            }
            return ResponseEntity.badRequest().body("Invalid Customer data received: " + devErrorMsg.toString());
        }
        Customer existingCustomer = customerService.findOneCustomer(id);
        if (existingCustomer != null) {
            existingCustomer.setCustomerName(customer.getCustomerName());
            existingCustomer.setEmail(customer.getEmail());
            // Update other properties as needed

            customerService.updateOneCustomer(existingCustomer);
            return ResponseEntity.ok("Customer updated successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
