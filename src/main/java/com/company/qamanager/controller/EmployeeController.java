package com.company.qamanager.controller;

import com.company.qamanager.entity.Employee;
import com.company.qamanager.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping
    public String employeePage(Model model) {

        model.addAttribute("employee", new Employee());
        model.addAttribute("employees", service.findAll());

        return "employees";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute Employee employee) {

        service.save(employee);

        return "redirect:/employees";
    }

    @GetMapping("/edit/{id}")
    public String editEmployee(@PathVariable Long id,
                               Model model) {

        model.addAttribute(
                "employee",
                service.findById(id)
        );

        model.addAttribute(
                "employees",
                service.findAll()
        );

        return "employees";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {

        service.deleteById(id);

        return "redirect:/employees";
    }
}