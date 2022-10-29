package com.employee.management.service;

import com.employee.management.exception.ResourceNotFoundException;
import com.employee.management.model.EmployeeModel;
import com.employee.management.model.ProjectModel;
import com.employee.management.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
public class EmployeeService implements IEmployeeService {
    Logger logger = LoggerFactory.getLogger(EmployeeService.class);

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public ResponseEntity<List> getAllEmployees() {
        try {
            logger.info("getAllEmployees() called");
            return new ResponseEntity<List>(employeeRepository.findAll(), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return new ResponseEntity<List>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<EmployeeModel> getEmployee(Integer id) {
            logger.trace("Function [getEmployee()] triggered with id : " + id.toString());
            return new ResponseEntity<EmployeeModel>(employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("employee","id",id)), HttpStatus.FOUND);
    }

    @Override
    public ResponseEntity<String> addEmployee(EmployeeModel employee) {
        try {
            employeeRepository.save(employee);
            return new ResponseEntity<String>("["+employee.getName()+"]"+" employee successfully created",HttpStatus.CREATED);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_IMPLEMENTED);
        }
    }

    @Override
    public ResponseEntity<String> updateEmployee(Integer id, EmployeeModel updateEmployee) {
        try {
            logger.info("Function updateEmployee() called with id :" + id.toString() + " Employee is :" + updateEmployee.toString());
            EmployeeModel employee = employeeRepository.findById(id).orElseThrow(()->new UsernameNotFoundException("Employee->"+updateEmployee.toString()+" with id:"+id+" not found"));
            employee.setName(updateEmployee.getName());
            employee.setEmail(updateEmployee.getEmail());
            employee.setPhoneNumber(updateEmployee.getPhoneNumber());
            employee.setModified(updateEmployee.getModified());
            employeeRepository.save(employee);
            return new ResponseEntity<String>("updated successfully", HttpStatus.OK);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @Override
    public ResponseEntity<String> deleteEmployee(Integer id) {
        try {
            logger.info("Function deleteEmployee() called and employee with id :"+id.toString()+" deleted");
            EmployeeModel employee = employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("employee","id",id));

            employeeRepository.delete(employee);
            return new ResponseEntity<String>("deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }



    @Override
    public String toString() {
        return "nothing";
    }
}
