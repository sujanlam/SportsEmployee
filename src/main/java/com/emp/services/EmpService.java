package com.emp.services;

import com.emp.entity.Employee;
import com.emp.repos.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpService {

    @Autowired
    private EmpRepository empRepository;

    public List<Employee> getAllEmployees(){
        List<Employee> allEmployees = empRepository.findAll();
        return allEmployees;
    }
}
