package com.employee.management.service;

import com.employee.management.model.EmployeeModel;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService {
    ResponseEntity<List> getAllEmployees();
    ResponseEntity<EmployeeModel> getEmployee(Integer id);
    ResponseEntity<String> addEmployee(EmployeeModel employee);
    ResponseEntity<String> updateEmployee(Integer id,EmployeeModel employee);
    ResponseEntity<String> deleteEmployee(Integer id);
    List<EmployeeModel>projectEmployeeRelation(String name);
    Optional<EmployeeModel>searchEmployeeByName(String name);
}
