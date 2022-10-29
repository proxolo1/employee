package com.employee.management.service;

import com.employee.management.model.ProjectModel;
import com.employee.management.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class IProjectService implements ProjectService{
    @Autowired
    private ProjectRepository projectRepo;
    @Override
    public ResponseEntity<List> getAllProjects() {
        return new ResponseEntity<>(projectRepo.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ProjectModel> getProject(String projectName) {
        return new ResponseEntity<>(projectRepo.findById(projectName).orElseThrow(),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ProjectModel> addProject(ProjectModel project) {
        return new ResponseEntity<>(projectRepo.save(project),HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<String> updateProject(String projectName, ProjectModel projectModel) {
        ProjectModel oldProject=projectRepo.findById(projectName).get();
        oldProject.setAllocation(projectModel.getAllocation());
        oldProject.setDuration(projectModel.getDuration());
        projectRepo.save(oldProject);
        return new ResponseEntity<>("updated successfully",HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<String> deleteEmployee(String projectName) {
        projectRepo.deleteById(projectName);
        return new ResponseEntity<>("deleted successfully",HttpStatus.OK);
    }
}
