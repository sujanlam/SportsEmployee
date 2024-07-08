package com.emp.repos;

import com.emp.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmpRepository extends JpaRepository<Employee, Long> {

    List<Employee> findEmployeesByAgeBefore(Integer age);
    List<Employee> findEmployeeByNationality(String nationality);
    Page<Employee> findAll(Pageable pageable);
}
