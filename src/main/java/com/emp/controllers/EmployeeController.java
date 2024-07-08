package com.emp.controllers;

import com.emp.dto.EmployeeRequest;
import com.emp.entity.Employee;
import com.emp.exceptions.UserNotFoundException;
import com.emp.services.EmpService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmpService empService;

    @GetMapping
    public ResponseEntity<List<Employee>> getListOfEmployees(){
        return ResponseEntity.ok(empService.getAllEmployees());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Employee>> getEmployeeById(@PathVariable Long id) throws UserNotFoundException {
        return ResponseEntity.ok(empService.getEmployeeById(id));
    }

    @PostMapping
    public ResponseEntity<?> addEmployee(@RequestBody @Valid EmployeeRequest employeeRequest){
        Employee employee = empService.createEmployee(employeeRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(employee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable Long id, @RequestBody EmployeeRequest employeeRequest){
       Employee employee = empService.updateEmployee(id, employeeRequest);
       return ResponseEntity.ok(employee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Long id){
        empService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/age/{age}")
    public ResponseEntity<List<Employee>> getEmployeesAgeBelow(@PathVariable int age){
        return ResponseEntity.ok(empService.getEmployeeLessThanAge(age));
    }

    @GetMapping("/nation/{nation}")
    public ResponseEntity<List<Employee>> getEmployeesByNation(@PathVariable String nation){
        return ResponseEntity.ok(empService.getEmployeeByNationality(nation));
    }

    @GetMapping("/by-page")
    public Page<Employee> getAllEmps(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return empService.getEmployeesByPage(page, size);
    }

}
