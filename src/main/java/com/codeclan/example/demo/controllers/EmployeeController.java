package com.codeclan.example.demo.controllers;

import com.codeclan.example.demo.models.Employee;
import com.codeclan.example.demo.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping(value = "/employees")
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @GetMapping(value= "/employees/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable Long id) {
        return employeeRepository.findById(id);
    }
 }
