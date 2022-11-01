package com.employee.management.repository;

import com.employee.management.model.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<EmployeeModel,Integer> {
    public List<EmployeeModel> findByProjectModelProjectName(String name);
    public Optional<EmployeeModel>findByName(String name);
}
