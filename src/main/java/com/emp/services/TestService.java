package com.emp.services;

import com.emp.entity.Employee;
import com.emp.repos.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @Autowired
    private EmpRepository empRepository;

    public Page<Employee> getEmployeesByPage(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return empRepository.findAll(pageable);
    }
}
