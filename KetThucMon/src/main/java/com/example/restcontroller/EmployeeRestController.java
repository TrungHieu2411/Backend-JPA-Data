package com.example.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Employee;
import com.example.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/employees")
public class EmployeeRestController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/list")
    public ResponseEntity<List<Employee>> getEmployeeList() {
        Employee employee = new Employee();
        List<Employee> employeeList = employeeService.getAllEmployee(employee);
        return ResponseEntity.ok(employeeList);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") int id) {
        employeeService.deleteOneEmployee(id);
        return ResponseEntity.ok("Employee deleted successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> detailEmployee(@PathVariable(value = "id", required = false) Integer id) {
        Employee employee = new Employee();
        if (id != null) {
            employee = employeeService.findOneEmployee(id);
        }
        return ResponseEntity.ok(employee);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createEmployee(@RequestBody @Valid Employee employee, BindingResult result) {
        if (result.hasErrors()) {
            StringBuilder devErrorMsg = new StringBuilder();
            List<ObjectError> allErrors = result.getAllErrors();
            for (ObjectError objectError : allErrors) {
                devErrorMsg.append(objectError.getDefaultMessage()).append("\n");
            }
            return ResponseEntity.badRequest().body("Invalid Employee data received: " + devErrorMsg.toString());
        }
        employeeService.addOneEmployee(employee);
        return ResponseEntity.ok("Employee created successfully");
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<String> updateEmployee(@RequestBody @Valid Employee employee, BindingResult result) {
        if (result.hasErrors()) {
            StringBuilder devErrorMsg = new StringBuilder();
            List<ObjectError> allErrors = result.getAllErrors();
            for (ObjectError objectError : allErrors) {
                devErrorMsg.append(objectError.getDefaultMessage()).append("\n");
            }
            return ResponseEntity.badRequest().body("Invalid Employee data received: " + devErrorMsg.toString());
        }
        employeeService.updateOneEmployee(employee);
        return ResponseEntity.ok("Employee updated successfully");
    }
}

