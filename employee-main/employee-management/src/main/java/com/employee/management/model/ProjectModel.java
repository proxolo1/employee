package com.employee.management.model;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class ProjectModel {
    @Id
//    private int id;
    private String projectName;
    private String allocation;
    private String duration;

    public ProjectModel( String projectName, String allocation, String duration) {
//        this.id = id;
        this.projectName = projectName;
        this.allocation = allocation;
        this.duration = duration;
    }

    public ProjectModel() {
    }

//    private int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getAllocation() {
        return allocation;
    }

    public void setAllocation(String allocation) {
        this.allocation = allocation;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
