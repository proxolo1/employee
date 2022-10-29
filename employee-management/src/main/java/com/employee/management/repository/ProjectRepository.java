package com.employee.management.repository;

import com.employee.management.model.ProjectModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<ProjectModel,String> {
}
