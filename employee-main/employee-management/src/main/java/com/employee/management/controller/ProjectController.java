package com.employee.management.controller;

import com.employee.management.model.ProjectModel;
import com.employee.management.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins="http://127.0.0.1:5500")
@RestController
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    private IProjectService projectService;
    @GetMapping("get-projects")
    public ResponseEntity<List> getProjects(){
        return projectService.getAllProjects();
    }
    @GetMapping("get-project/{name}")
    public ResponseEntity<ProjectModel>getProject(@PathVariable String name){
        return projectService.getProject(name);
    }
    @PostMapping("add-project")
    public ResponseEntity<ProjectModel>addProject(@RequestBody ProjectModel projectModel){
        return projectService.addProject(projectModel);
    }
    @PutMapping("update-project/{name}")
    public ResponseEntity<String>updateProject(@PathVariable String name,@RequestBody ProjectModel projectModel){
        return  projectService.updateProject(name,projectModel);    }
    @DeleteMapping("delete-project/{name}")
    public ResponseEntity<String>deleteProject(@PathVariable String name){
        return projectService.deleteEmployee(name);
    }
}
