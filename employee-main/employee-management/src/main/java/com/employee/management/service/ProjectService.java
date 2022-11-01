package com.employee.management.service;

import com.employee.management.model.EmployeeModel;
import com.employee.management.model.ProjectModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProjectService {
    ResponseEntity<List> getAllProjects();
    ResponseEntity<ProjectModel> getProject(String projectName);
    ResponseEntity<ProjectModel> addProject(ProjectModel project);
    ResponseEntity<String> updateProject(String projectName,ProjectModel projectModel);
    ResponseEntity<String> deleteEmployee(String projectName);

}
