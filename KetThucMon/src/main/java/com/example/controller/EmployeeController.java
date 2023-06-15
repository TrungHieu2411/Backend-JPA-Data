package com.example.controller;

import com.example.model.Employee;
import com.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/list")
    public String getEmployeeList(Model model) {
    	Employee employee = new Employee();
        List<Employee> employeeList = employeeService.getAllEmployee(employee);
        model.addAttribute("employeeList", employeeList);
        return "employee/employee_list";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable("id") int id) {
        employeeService.deleteOneEmployee(id);
        return "redirect:/employee/list";
    }

    @GetMapping(value = {"/detail", "/detail/", "/detail/{id}"})
    public String detailEmployee(@PathVariable(value = "id", required = false) Integer id, Model model) {
        Employee employee = new Employee();
        if (id != null) {
            employee = employeeService.findOneEmployee(id);
        }
        model.addAttribute("employee", employee);
        return "employee/employee_form";
    }

    @PostMapping(value = "/detail", params = "create")
    public String createEmployee(@ModelAttribute("employee") Employee employee, Model model) {
        employeeService.addOneEmployee(employee);
        model.addAttribute("message", "Employee created successfully");
        return "redirect:/employee/list";
    }

    @PostMapping(value = "/detail", params = "update")
    public String updateEmployee(@ModelAttribute("employee") Employee employee, Model model) {
        employeeService.updateOneEmployee(employee);
        model.addAttribute("message", "Employee updated successfully");
        return "redirect:/employee/list";
    }
}

