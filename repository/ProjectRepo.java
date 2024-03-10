package com.Home.ProjectManagementSystem.repository;

import com.Home.ProjectManagementSystem.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepo extends JpaRepository<Project, Long> {


}
