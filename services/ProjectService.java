package com.Home.ProjectManagementSystem.services;

import com.Home.ProjectManagementSystem.models.Project;
import com.Home.ProjectManagementSystem.repository.ProjectRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProjectService {

    Project createProject(Project project) ;

    List<Project> getAllProjects();

    Project getProjectById(Long id);

    Project updateProject(Long id, Project project);

    void deleteProject(Long id);
}
