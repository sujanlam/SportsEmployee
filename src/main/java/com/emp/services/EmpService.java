package com.emp.services;

import com.emp.dto.EmployeeRequest;
import com.emp.entity.Employee;
import com.emp.exceptions.UserNotFoundException;
import com.emp.repos.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpService {

    @Autowired
    private EmpRepository empRepository;

    public List<Employee> getAllEmployees(){
        List<Employee> allEmployees = empRepository.findAll();
        return allEmployees;
    }

    public Optional<Employee> getEmployeeById(Long id) throws UserNotFoundException {
         Optional<Employee> employee = empRepository.findById(id);
         if(employee != null){
             return employee;
         }else {
             throw new UserNotFoundException("User not found with id: "+id);
         }
    }

    /*public Employee createEmployee(Employee emp){
        return empRepository.save(emp);
    }*/

    public Employee createEmployee(EmployeeRequest empRequest){
        Employee emp = Employee.build((long) 0.0, empRequest.getFname(), empRequest.getFname(), empRequest.getAge(),
                empRequest.getClub(), empRequest.getGoals_scored(), empRequest.getNationality());
        return empRepository.save(emp);
    }

    public Employee updateEmployee(Long id, EmployeeRequest updatedEmployee){
      Optional<Employee> existingEmpData = empRepository.findById(id);
        if(existingEmpData.isPresent()){
            Employee readyToBeSaved = existingEmpData.get();
            readyToBeSaved.setFname(updatedEmployee.getFname());
            readyToBeSaved.setLname(updatedEmployee.getLname());
            readyToBeSaved.setAge(updatedEmployee.getAge());
            readyToBeSaved.setClub(updatedEmployee.getClub());
            readyToBeSaved.setNationality(updatedEmployee.getNationality());

            return empRepository.save(readyToBeSaved);
        }else{
            throw new IllegalArgumentException("Employee with "+  id +" not found");
        }
    }


    public void deleteEmployee(Long id){
        empRepository.deleteById(id);
    }

    public List<Employee> getEmployeeLessThanAge(int age){
        return empRepository.findEmployeesByAgeBefore(age);
    }

    public List<Employee> getEmployeeByNationality(String nationality){
        return empRepository.findEmployeeByNationality(nationality);
    }

    public Page<Employee> getEmployeesByPage(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return empRepository.findAll(pageable);
    }

}
