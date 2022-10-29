package com.employee.management.controller;

import com.employee.management.dto.LoginDto;
import com.employee.management.dto.RegisterDto;
import com.employee.management.model.EmployeeModel;
import com.employee.management.model.Role;
import com.employee.management.model.User;
import com.employee.management.repository.EmployeeRepository;
import com.employee.management.repository.RoleRepository;
import com.employee.management.repository.UserRepository;
import com.employee.management.service.IEmployeeService;


import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.List;
import org.slf4j.Logger;
@CrossOrigin(origins="http://127.0.0.1:5500")
@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;
    @Autowired
    private EmployeeRepository repo;
    @GetMapping("/")
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("./index.html");

        return modelAndView;
    }

    @GetMapping("get-employees")
    public ResponseEntity<List>getAllEmployees(){

        return employeeService.getAllEmployees();
    }
    @GetMapping("get-employee/{id}")
    public ResponseEntity<EmployeeModel> getEmployee(@PathVariable Integer id){
        return employeeService.getEmployee(id);
    }
//    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("add-employee")
    public ResponseEntity<String> addEmployee(@RequestBody EmployeeModel employee){
       return employeeService.addEmployee(employee);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("update-employee/{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable Integer id, @RequestBody EmployeeModel employee){
       return employeeService.updateEmployee(id, employee);

    }
    @PreAuthorize("hasRole('DEVELOPER')")
    @DeleteMapping("delete-employee/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Integer id){
        return employeeService.deleteEmployee(id);
    }
    @GetMapping("/demo/{name}")
    public List<EmployeeModel> demo(@PathVariable String name){
        return repo.findByProjectModelProjectName(name);
    }
    @GetMapping("/*")
    public ModelAndView unWanted(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("./show.html");
        return modelAndView;
    }
}
