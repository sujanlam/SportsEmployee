package com.emp.controllers;

import com.emp.entity.Employee;
import com.emp.services.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmpService empService;

    @GetMapping("/msg")
    public String getMsg(){
        return "Hello World";
    }

    @GetMapping("/employees")
    public List<Employee> getListOfEmployees(){
        return empService.getAllEmployees();
    }
}
