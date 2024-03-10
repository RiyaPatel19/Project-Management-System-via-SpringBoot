package com.Home.ProjectManagementSystem.controllers;

import com.Home.ProjectManagementSystem.models.Project;
import com.Home.ProjectManagementSystem.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {

    private ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    // creating project

    @PostMapping
    public ResponseEntity<Project> createProject(@RequestBody Project project) {

        try {
            return new ResponseEntity<>(projectService.createProject(project), HttpStatus.CREATED);

        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }

    // retrieving all projects

    @GetMapping
    public ResponseEntity<List<Project>> getAllProjects() {

        try {
            List<Project> projects = projectService.getAllProjects();

            if (projects.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(projects, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // get project by id

    @GetMapping("/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable Long id) {

        try {
            Project project = projectService.getProjectById(id);

            if (project != null) {
                return new ResponseEntity<>(project, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // updating project

    @PutMapping("/{id}")
    public ResponseEntity<Project> updateProject(@PathVariable Long id, @RequestBody Project project) {
        try {
            Project existingProject = projectService.getProjectById(id);

            if (existingProject != null) {

                existingProject.setName(project.getName());
                existingProject.setDescription(project.getDescription());
                existingProject.setStartDate(project.getStartDate());
                existingProject.setEndDate(project.getEndDate());

                Project projectResult = projectService.updateProject(id, existingProject);

                return new ResponseEntity<>(projectResult, HttpStatus.OK);

            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable Long id) {
        try {
            projectService.deleteProject(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}



