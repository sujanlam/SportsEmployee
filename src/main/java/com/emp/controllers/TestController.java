package com.emp.controllers;

import com.emp.entity.Employee;
import com.emp.services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test-emps")
@CrossOrigin(origins = "http://localhost:3000")
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping
    public Page<Employee> getAllEmps(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return testService.getEmployeesByPage(page, size);
    }
}
